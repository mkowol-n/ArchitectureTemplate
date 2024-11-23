package pl.nepapp.features.login.impl

import org.koin.core.annotation.Factory
import pl.nepapp.data.authorization.AuthorizationRepository

@Factory
class LoginUseCase(private val authrorizationRepository: AuthorizationRepository) {
    suspend operator fun invoke() {
        authrorizationRepository.login()
    }
}