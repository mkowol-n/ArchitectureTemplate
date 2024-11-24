package pl.nepapp.features.main

import org.koin.android.annotation.KoinViewModel
import pl.nepapp.core.navigation.Direction
import pl.nepapp.core.settings.UserStorage
import pl.nepapp.core.statemanagement.Async
import pl.nepapp.core.statemanagement.BaseViewModel
import pl.nepapp.core.statemanagement.Uninitialized
import pl.nepapp.core.statemanagement.async

@KoinViewModel
class MainViewModel(
    private val userStorage: UserStorage
) :
    BaseViewModel<MainViewModel.MainState, MainViewModel.MainSideEffect>(MainState()) {

    data class MainState(
        val initialScreenRequest: Async<Direction> = Uninitialized
    )

    sealed class MainSideEffect() {
        data object LogoutUser : MainSideEffect()
    }

    init {
        initialize()
    }

    private fun initialize() {
        intent {
            async {

            }
        }
    }
}