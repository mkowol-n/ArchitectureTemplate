package pl.nepapp.navigation.impl

import androidx.compose.runtime.staticCompositionLocalOf

val LocalMyNavigator = staticCompositionLocalOf<Navigator?> {
    null
}