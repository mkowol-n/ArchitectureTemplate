package pl.nepapp.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import pl.nepapp.navigation.api.Screen
import pl.nepapp.navigation.impl.LocalNavigator
import pl.nepapp.navigation.impl.Navigator
import pl.nepapp.navigation.impl.ScreenRegister
import pl.nepapp.navigation.impl.composableScreen

@Composable
internal fun BaseNavHost(
    startDestination: Screen,
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

inline fun <reified T: Screen> ScreenRegister<T>.register(navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composableScreen<T> {
        Content()
    }
}