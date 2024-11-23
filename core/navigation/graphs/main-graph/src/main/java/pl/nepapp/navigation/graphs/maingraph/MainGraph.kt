package pl.nepapp.navigation.graphs.maingraph

import androidx.compose.runtime.Composable
import org.koin.compose.koinInject
import pl.nepapp.features.dashboard.DashboardScreenRegistry
import pl.nepapp.features.login.LoginDirection
import pl.nepapp.features.login.LoginScreenRegistry
import pl.nepapp.navigation.graphs.base.BaseNavHost
import pl.nepapp.navigation.graphs.base.registerWithSlideAnimation

@Composable
fun MainGraph(
    dashboardScreenRegistry: DashboardScreenRegistry = koinInject(),
    loginScreenRegistry: LoginScreenRegistry = koinInject(),
) {
    BaseNavHost(
        startDestination = LoginDirection
    ) {
        loginScreenRegistry.registerWithSlideAnimation(navGraphBuilder = this@BaseNavHost)
        dashboardScreenRegistry.registerWithSlideAnimation(navGraphBuilder = this@BaseNavHost)
    }
}