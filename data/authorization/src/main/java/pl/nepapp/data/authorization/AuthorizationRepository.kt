package pl.nepapp.data.authorization

import pl.nepapp.data.authorization.models.LoginResponse

interface AuthorizationRepository {
    suspend fun login(email: String, password: String): LoginResponse
}