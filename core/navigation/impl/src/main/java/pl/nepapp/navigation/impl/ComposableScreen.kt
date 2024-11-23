package pl.nepapp.navigation.impl

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.nepapp.navigation.api.Screen

inline fun <reified T : Screen> NavGraphBuilder.composableScreen(
    noinline enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? = {
        slideInHorizontally(
            initialOffsetX = { it }, animationSpec = spring(
                stiffness = Spring.StiffnessVeryLow,
                visibilityThreshold = IntOffset.VisibilityThreshold,
            )
        )
    },
    noinline exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? = {
        slideOutHorizontally(
            targetOffsetX = { -it }, animationSpec = spring(
                stiffness = Spring.StiffnessVeryLow,
                visibilityThreshold = IntOffset.VisibilityThreshold
            )
        )
    },
    noinline popExitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? = {
        slideOutHorizontally(
            targetOffsetX = { it }, animationSpec = spring(
                stiffness = Spring.StiffnessVeryLow,
                visibilityThreshold = IntOffset.VisibilityThreshold
            )
        )
    },
    noinline popEnterTransition:
    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? = {
        slideInHorizontally(
            initialOffsetX = { -it }, animationSpec = spring(
                stiffness = Spring.StiffnessVeryLow,
                visibilityThreshold = IntOffset.VisibilityThreshold
            )
        )
    },
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable<T>(
        enterTransition = enterTransition,
        exitTransition = exitTransition,
        popExitTransition = popExitTransition,
        popEnterTransition = popEnterTransition,
        content = content,
    )
}