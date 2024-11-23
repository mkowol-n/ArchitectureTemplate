package pl.nepapp.navigation.impl

import androidx.compose.runtime.staticCompositionLocalOf

val LocalNavigator = staticCompositionLocalOf<Navigator?> {
    null
}