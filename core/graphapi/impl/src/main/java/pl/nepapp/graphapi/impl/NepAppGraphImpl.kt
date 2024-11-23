package pl.nepapp.graphapi.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.koin.core.annotation.Single
import pl.nepapp.features.dashboard.DashboardDirection
import pl.nepapp.features.dashboard.impl.DashboardContent
import pl.nepapp.features.login.LoginDirection
import pl.nepapp.features.login.impl.LoginContent
import pl.nepapp.graphapi.NepAppGraph

@Single
class NepAppGraphImpl: NepAppGraph {

    @Composable
    override fun Route() {
        BaseNavHost(
            startDestination = LoginDirection,
        ) {
            registerWithSlideAnimation<LoginDirection> {
                LoginContent()
            }
            registerWithSlideAnimation<DashboardDirection> {
                DashboardContent()
            }
        }
    }
}
fun NavGraphBuilder.getGraph(): NavGraphBuilder.() -> Unit = {
    composable<LoginDirection> {
        LoginContent()
    }
    composable<DashboardDirection> {
        DashboardContent()
    }
}