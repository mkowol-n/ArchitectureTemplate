package pl.nepapp.core.config.http

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import pl.nepapp.core.common.handlers.LogoutHandler
import pl.nepapp.core.settings.local.UserStorage
import pl.nepapp.data.authorization.remote.AuthorizationService

interface TokenAuthenticator : Authenticator

@Single(binds = [TokenAuthenticator::class])
class TokenAuthenticatorImpl(
    private val userStorage: UserStorage,
    private val logoutHandler: LogoutHandler
) : TokenAuthenticator, KoinComponent {

    private val authorizationService by inject<AuthorizationService>()
    private val mutex = Mutex()

    override fun authenticate(route: Route?, response: Response): Request? {
        if (isAuthorizationUrl(response.request)) {
            return null
        }

        if (!hasBearerAuthorizationToken(response)) {
            return null
        }

        return runBlocking {
            val accessTokenBefore = userStorage.getAccessToken()
            mutex.withLock {
                val currentToken = userStorage.getAccessToken()

                if (accessTokenBefore != currentToken) {
                    return@runBlocking rewriteRequest(response.request, currentToken)
                }

                val refreshTokenResponse = authorizationService.refreshToken(
                    refreshToken = requireNotNull(userStorage.getRefreshToken())
                ).execute()

                if (refreshTokenResponse.isSuccessful) {
                    val body = requireNotNull(refreshTokenResponse.body())
                    userStorage.saveTokens(
                        accessToken = body.accessToken,
                        refreshToken = body.refreshToken
                    )
                    return@runBlocking rewriteRequest(response.request, body.accessToken)
                } else {
                    logoutHandler.logout()
                    return@runBlocking null
                }
            }
        }
    }

    /**
     * Rewrites given [staleRequest] to have new auth token and retry counter.
     */
    private fun rewriteRequest(
        staleRequest: Request,
        authToken: String?,
    ): Request {
        return staleRequest.newBuilder()
            .header(
                "Authorization",
                "Bearer $authToken"
            )
            .build()
    }

    private fun hasBearerAuthorizationToken(response: Response): Boolean {
        val authorizationHeader = response.request.header("Authorization")
        return authorizationHeader?.startsWith("Bearer ") ?: false
    }

    /**
     * Checks if given [request] is authorization one.
     */
    private fun isAuthorizationUrl(request: Request): Boolean {
        if (!request.method.equals("POST", true)) return false
        val path = request.url.encodedPath
        return false // TODO Add proper logic for actual project
    }

}