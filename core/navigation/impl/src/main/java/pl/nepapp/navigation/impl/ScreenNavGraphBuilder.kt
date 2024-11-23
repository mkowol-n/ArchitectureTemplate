package pl.nepapp.navigation.impl

import androidx.compose.runtime.Composable
import pl.nepapp.navigation.api.Screen

abstract class ScreenRegister<T: Screen> {
    @Composable
    abstract fun Content()
}