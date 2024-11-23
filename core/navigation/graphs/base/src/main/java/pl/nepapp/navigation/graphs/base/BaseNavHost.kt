package pl.nepapp.navigation.graphs.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import pl.nepapp.navigation.api.Direction
import pl.nepapp.navigation.impl.LocalNavigator
import pl.nepapp.navigation.impl.Navigator

@Composable
fun BaseNavHost(
    startDestination: Direction,
    builder: NavGraphBuilder.() -> Unit
) {
    val navController = rememberNavController()
    val parentNavigator = LocalNavigator.current

    CompositionLocalProvider(
        LocalNavigator provides Navigator(parent = parentNavigator, navigator = navController)
    ){
        NavHost(
            startDestination = startDestination,
            navController = navController,
            builder = builder
        )
    }
}
