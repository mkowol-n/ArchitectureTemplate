package pl.nepapp.architecturetemplate

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.android.annotation.KoinViewModel
import pl.nepapp.core.settings.UserStorage

@KoinViewModel
class MainActivityViewModel(
    private val userStorage: UserStorage
): ViewModel() {
    val isFirstScreenLogin: MutableStateFlow<Boolean?> = MutableStateFlow(null)

    init {
        viewModelScope.launch {
            val isUserLoggedOut = userStorage.getAccessToken() == null
            isFirstScreenLogin.update {
                isUserLoggedOut
            }
        }
    }
}