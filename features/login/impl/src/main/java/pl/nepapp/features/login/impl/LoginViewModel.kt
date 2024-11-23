package pl.nepapp.features.login.impl

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import pl.nepapp.core.statemanagement.Async
import pl.nepapp.core.statemanagement.BaseViewModel
import pl.nepapp.core.statemanagement.Uninitialized

@KoinViewModel
class LoginViewModel(
    private val loginUseCase: LoginUseCase
): BaseViewModel<LoginViewModel.LoginState, Unit>(
    LoginState()
) {
    data class LoginState(
        val loginRequest: Async<Unit> = Uninitialized
    )

    fun test() {
        viewModelScope.launch {
            loginUseCase()
        }
    }

}