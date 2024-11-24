package pl.nepapp.features.main

import kotlinx.coroutines.flow.collectLatest
import org.koin.android.annotation.KoinViewModel
import pl.nepapp.core.common.handlers.LogoutHandler
import pl.nepapp.core.statemanagement.BaseViewModel

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