package pl.nepapp.core.navigation.impl

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import pl.nepapp.core.navigation.Direction
import pl.nepapp.core.navigation.impl.animations.EnterSlideInHorizontally
import pl.nepapp.core.navigation.impl.animations.ExitSlideOutHorizontally
import pl.nepapp.core.navigation.impl.animations.NewEnterSlideInHorizontally
import pl.nepapp.core.navigation.impl.animations.NewExitSlideOutHorizontally
import pl.nepapp.core.navigation.impl.animations.NewPopExitSlideInHorizontally
import pl.nepapp.core.navigation.impl.animations.NewPopExitSlideOutHorizontally
import pl.nepapp.core.navigation.impl.animations.PopExitSlideInHorizontally
import pl.nepapp.core.navigation.impl.animations.PopExitSlideOutHorizontally
import kotlin.reflect.KType

inline fun <reified T : Direction> NavGraphBuilder.registerWithSlideAnimation(
    typeMap: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable<T>(
        enterTransition = { EnterSlideInHorizontally },
        exitTransition = { ExitSlideOutHorizontally },
        popExitTransition = { PopExitSlideOutHorizontally },
        popEnterTransition = { PopExitSlideInHorizontally },
        content = content,
        typeMap = typeMap
    )
}

inline fun <reified T : Direction> NavGraphBuilder.registerWithNewSlideAnimation(
    typeMap: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable<T>(
        enterTransition = { NewEnterSlideInHorizontally },
        exitTransition = { NewExitSlideOutHorizontally },
        popExitTransition = { NewPopExitSlideOutHorizontally },
        popEnterTransition = { NewPopExitSlideInHorizontally },
        content = content,
        typeMap = typeMap
    )
}