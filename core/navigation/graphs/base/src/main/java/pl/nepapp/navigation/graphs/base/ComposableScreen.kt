package pl.nepapp.navigation.graphs.base

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.nepapp.navigation.api.Direction

inline fun <reified T : Direction> NavGraphBuilder.composableScreen(
    enterTransition: EnterTransition,
    exitTransition: ExitTransition,
    popExitTransition: ExitTransition,
    popEnterTransition: EnterTransition,
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable<T>(
        enterTransition = { enterTransition },
        exitTransition = { exitTransition },
        popExitTransition = { popExitTransition },
        popEnterTransition = { popEnterTransition },
        content = content,
    )
}