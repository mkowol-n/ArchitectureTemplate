package pl.nepapp.navigation.api

import androidx.compose.runtime.Composable

abstract class ScreenRegistry<T: Direction> {
    @Composable
    abstract fun Content()
}