package pl.nepapp.features.main

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import pl.nepapp.core.common.handlers.LogoutHandler
import pl.nepapp.core.statemanagement.BaseViewModel
import pl.nepapp.core.statemanagement.Uninitialized
import pl.nepapp.core.statemanagement.async

@KoinViewModel
class MainViewModel(
    private val logoutHandler: LogoutHandler
) :
    BaseViewModel<Unit, MainViewModel.MainSideEffect>(Unit) {

    sealed class MainSideEffect() {
        data object LogoutUser : MainSideEffect()
    }

    init {
        initialize()
    }

    private fun initialize() {
        intent(registerIdling = false) {
            logoutHandler.logoutFlow.collectLatest {
                postSideEffect(MainSideEffect.LogoutUser)
            }
        }
    }
}