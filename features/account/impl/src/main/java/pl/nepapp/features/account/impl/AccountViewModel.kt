package pl.nepapp.features.account.impl

import androidx.lifecycle.ViewModel
import org.koin.android.annotation.KoinViewModel
import pl.nepapp.core.settings.UserStorage
import pl.nepapp.core.statemanagement.Async
import pl.nepapp.core.statemanagement.BaseViewModel
import pl.nepapp.core.statemanagement.Uninitialized
import pl.nepapp.core.statemanagement.async

@KoinViewModel
class AccountViewModel(
    private val userStorage: UserStorage
): BaseViewModel<AccountViewModel.AccountState, AccountViewModel.AccountSideEffect>(AccountState()) {


    data class AccountState(
        val logoutRequest: Async<Unit> = Uninitialized
    )

    sealed class AccountSideEffect {
        data object LogoutUser: AccountSideEffect()
    }

    fun logout() {
        intent {
            async {
                userStorage.clear()
                postSideEffect(AccountSideEffect.LogoutUser)
            }.execute {
                state.copy(
                    logoutRequest = it
                )
            }
        }
    }
}