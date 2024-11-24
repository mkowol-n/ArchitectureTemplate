package pl.nepapp.features.login.impl

import org.koin.core.annotation.Factory
import pl.nepapp.data.authorization.AuthorizationRepository

@Factory
class LoginUseCase(
    private val authrorizationRepository: AuthorizationRepository,
    private val userStorage: pl.nepapp.core.settings.UserStorage
) {
    suspend operator fun invoke(email: String, password: String) {
        val response = authrorizationRepository.login(
            email = email,
            password = password
        )
        userStorage.saveTokens(
            accessToken = response.accessToken,
            refreshToken = response.refreshToken
        )
    }
}