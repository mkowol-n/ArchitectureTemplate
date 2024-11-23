package pl.nepapp.navigation.graphs

import androidx.compose.runtime.Composable
import pl.nepapp.features.dashboard.impl.DashboardScreenActual
import pl.nepapp.features.login.LoginScreen
import pl.nepapp.features.login.impl.LoginScreenActual

@Composable
fun MainGraph() {
    BaseNavHost(
        startDestination = LoginScreen
    ) {
        LoginScreenActual.register(navGraphBuilder = this@BaseNavHost)
        DashboardScreenActual.register(navGraphBuilder = this@BaseNavHost)
    }
}