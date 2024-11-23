package pl.nepapp.features.login.impl

import org.koin.core.annotation.Factory
import pl.nepapp.core.settings.local.UserStorage
import pl.nepapp.data.authorization.AuthorizationRepository

@Factory
class LoginUseCase(
    private val authrorizationRepository: AuthorizationRepository,
    private val userStorage: UserStorage
) {
    suspend operator fun invoke() {
        val response = authrorizationRepository.login()
        userStorage.saveTokens(
            accessToken = response.accessToken,
            refreshToken = response.refreshToken
        )
    }
}