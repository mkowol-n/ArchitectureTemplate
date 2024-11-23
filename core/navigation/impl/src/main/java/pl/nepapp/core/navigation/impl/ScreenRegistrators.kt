package pl.nepapp.core.navigation.impl

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.nepapp.core.navigation.Direction
import pl.nepapp.core.navigation.impl.animations.EnterSlideInHorizontally
import pl.nepapp.core.navigation.impl.animations.ExitSlideOutHorizontally
import pl.nepapp.core.navigation.impl.animations.PopExitSlideInHorizontally
import pl.nepapp.core.navigation.impl.animations.PopExitSlideOutHorizontally

internal inline fun <reified T : Direction> NavGraphBuilder.registerWithSlideAnimation(
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable<T>(
        enterTransition = { EnterSlideInHorizontally },
        exitTransition = { ExitSlideOutHorizontally },
        popExitTransition = { PopExitSlideOutHorizontally },
        popEnterTransition = { PopExitSlideInHorizontally },
        content = content
    )
}