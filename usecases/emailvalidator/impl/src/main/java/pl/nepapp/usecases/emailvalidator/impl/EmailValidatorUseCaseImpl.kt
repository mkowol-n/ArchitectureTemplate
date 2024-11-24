package pl.nepapp.usecases.emailvalidator.impl

import android.util.Patterns
import org.koin.core.annotation.Factory
import pl.nepapp.usecases.emailvalidator.EmailValidatorUseCase

@Factory
class EmailValidatorUseCaseImpl: EmailValidatorUseCase {
    override fun invoke(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}