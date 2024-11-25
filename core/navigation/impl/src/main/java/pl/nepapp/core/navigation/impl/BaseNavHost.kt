package pl.nepapp.core.navigation.impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import pl.nepapp.core.navigation.Direction
import pl.nepapp.core.navigation.LocalNavigator

@Composable
fun BaseNavHost(
    startDestination: Direction,
    navController: NavHostController = rememberNavController(),
    builder: NavGraphBuilder.() -> Unit,
) {
    val parentNavigator = LocalNavigator.current

    CompositionLocalProvider(
        LocalNavigator provides NavigatorImpl(_parent = parentNavigator, navController = navController)
    ){
        NavHost(
            startDestination = startDestination,
            navController = navController,
            builder = builder
        )
    }
}
