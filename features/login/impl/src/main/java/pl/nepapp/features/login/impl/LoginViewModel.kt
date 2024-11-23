package pl.nepapp.features.login.impl

import org.koin.android.annotation.KoinViewModel
import pl.nepapp.core.statemanagement.Async
import pl.nepapp.core.statemanagement.BaseViewModel
import pl.nepapp.core.statemanagement.Uninitialized

@KoinViewModel
class LoginViewModel: BaseViewModel<LoginViewModel.LoginState, Unit>(
    LoginState()
) {
    data class LoginState(
        val loginRequest: Async<Unit> = Uninitialized
    )

    fun test() {

    }

}