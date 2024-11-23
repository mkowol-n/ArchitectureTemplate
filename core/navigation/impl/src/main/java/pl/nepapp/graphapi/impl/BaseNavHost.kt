package pl.nepapp.navigation.impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import pl.nepapp.navigation.Direction
import pl.nepapp.navigation.LocalNavigator

@Composable
internal fun BaseNavHost(
    startDestination: Direction,
    builder: NavGraphBuilder.() -> Unit
) {
    val navController = rememberNavController()
    val parentNavigator = LocalNavigator.current

    CompositionLocalProvider(
        LocalNavigator provides NavigatorImpl(_parent = parentNavigator, navigator = navController)
    ){
        NavHost(
            startDestination = startDestination,
            navController = navController,
            builder = builder
        )
    }
}
