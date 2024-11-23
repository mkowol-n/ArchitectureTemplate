package pl.nepapp.graphapi.impl

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.nepapp.graphapi.impl.animations.EnterSlideInHorizontally
import pl.nepapp.graphapi.impl.animations.ExitSlideOutHorizontally
import pl.nepapp.graphapi.impl.animations.PopExitSlideInHorizontally
import pl.nepapp.graphapi.impl.animations.PopExitSlideOutHorizontally
import pl.nepapp.navigation.api.Direction

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