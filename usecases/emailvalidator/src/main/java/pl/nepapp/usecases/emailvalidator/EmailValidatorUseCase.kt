package pl.nepapp.usecases.emailvalidator

interface EmailValidatorUseCase {
    operator fun invoke(email: String): Boolean
}