package pl.nepapp.navigation.graphs.base

import androidx.navigation.NavGraphBuilder
import pl.nepapp.navigation.api.Direction
import pl.nepapp.navigation.api.ScreenRegistry
import pl.nepapp.navigation.graphs.base.animations.EnterSlideInHorizontally
import pl.nepapp.navigation.graphs.base.animations.ExitSlideOutHorizontally
import pl.nepapp.navigation.graphs.base.animations.PopExitSlideInHorizontally
import pl.nepapp.navigation.graphs.base.animations.PopExitSlideOutHorizontally

inline fun <reified T : Direction> ScreenRegistry<T>.registerWithSlideAnimation(navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composableScreen<T>(
        enterTransition = EnterSlideInHorizontally,
        exitTransition = ExitSlideOutHorizontally,
        popExitTransition = PopExitSlideOutHorizontally,
        popEnterTransition = PopExitSlideInHorizontally
    ) {
        Content()
    }
}