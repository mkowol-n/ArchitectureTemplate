package pl.nepapp.core.config.http

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import org.koin.core.annotation.Single

interface TokenAuthenticator: Authenticator

@Single
class TokenAuthenticatorImpl: TokenAuthenticator {
    private val lock = Mutex()

    override fun authenticate(route: Route?, response: Response): Request? {
        if (isAuthorizationUrl(response.request)) {
            return null
        }

        if (!hasBearerAuthorizationToken(response)) {
            return null
        }

        val accessTokenBefore = "" //TODO

        return runBlocking {
            lock.withLock {
                return@runBlocking null //TODO
            }
        }


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