package pl.nepapp.data.authorization.impl

import pl.nepapp.core.config.http.NetworkResponseConverter
import pl.nepapp.data.authorization.AuthorizationRepository
import pl.nepapp.data.authorization.models.LoginResponse
import pl.nepapp.data.authorization.remote.AuthorizationService

class AuthorizationRepositoryImpl(
    private val authorizationService: AuthorizationService,
    private val networkResponseConverter: NetworkResponseConverter,
) : AuthorizationRepository {
    override suspend fun login(): LoginResponse {
        return networkResponseConverter(authorizationService::login) {
            LoginResponse(
                accessToken = it.accessToken,
                refreshToken = it.refreshToken
            )
        }
    }
}