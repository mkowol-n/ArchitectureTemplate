package pl.nepapp.features.login.impl

import org.koin.core.annotation.Factory
import pl.nepapp.data.authorization.AuthorizationRepository

@Factory
class LoginUseCase(
    private val authrorizationRepository: AuthorizationRepository,
    private val userStorage: pl.nepapp.core.settings.UserStorage
) {
    suspend operator fun invoke() {
        val response = authrorizationRepository.login()
        userStorage.saveTokens(
            accessToken = response.accessToken,
            refreshToken = response.refreshToken
        )
    }
}