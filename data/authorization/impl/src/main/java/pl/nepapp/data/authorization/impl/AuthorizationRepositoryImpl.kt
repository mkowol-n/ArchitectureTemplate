package pl.nepapp.data.authorization.impl

import pl.nepapp.data.authorization.AuthorizationRepository
import pl.nepapp.data.authorization.models.LoginResponse
import pl.nepapp.data.authorization.remote.AuthorizationService

class AuthorizationRepositoryImpl(
    private val authorizationService: AuthorizationService
): AuthorizationRepository {
    override suspend fun login(): LoginResponse {
        authorizationService.login()
        throw Exception("dsafasfa asf asf asf asf ")
    }
}