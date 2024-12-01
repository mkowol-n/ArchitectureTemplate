package pl.nepapp.features.login.impl

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import pl.nepapp.core.statemanagement.Async
import pl.nepapp.core.statemanagement.BaseViewModel
import pl.nepapp.core.statemanagement.Uninitialized
import pl.nepapp.core.statemanagement.async
import pl.nepapp.coreui.inputField.InputFieldState
import pl.nepapp.usecases.combined.CombinedUseCase
import pl.nepapp.usecases.emailvalidator.EmailValidatorUseCase

@KoinViewModel
class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val combinedUseCase: CombinedUseCase,
    private val emailValidatorUseCase: EmailValidatorUseCase,
) : BaseViewModel<LoginViewModel.LoginState, LoginViewModel.LoginSideEffect>(
    LoginState()
) {
    data class LoginState(
        val loginRequest: Async<Unit> = Uninitialized,
        val loginInputField: InputFieldState = InputFieldState("test"),
        val passwordInputField: InputFieldState = InputFieldState("test"),
    ) {
        val isButtonEnabled =
            loginInputField.isValidAndNotBlank && passwordInputField.isValidAndNotBlank
    }

    init {
        viewModelScope.launch {
            Log.d("usecase", combinedUseCase.invoke())
            Log.d("usecase", emailValidatorUseCase.invoke("test").toString())
        }

    }
    sealed class LoginSideEffect() {
        data object NavigateToDashboard : LoginSideEffect()
    }

    fun login() {
        intent {
            async {
                loginUseCase(
                    email = state.loginInputField.value,
                    password = state.passwordInputField.value
                )
                postSideEffect(LoginSideEffect.NavigateToDashboard)
            }.execute {
                state.copy(
                    loginRequest = it
                )
            }
        }
    }

    fun onLoginChange(value: String) {
        blockingIntent {
            reduce {
                state.copy(
                    loginInputField = InputFieldState(value)
                )
            }
        }
    }

    fun onPasswordChange(value: String) {
        blockingIntent {
            reduce {
                state.copy(
                    passwordInputField = InputFieldState(value)
                )
            }
        }
    }

}