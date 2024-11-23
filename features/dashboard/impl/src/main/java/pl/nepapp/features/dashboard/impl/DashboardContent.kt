package pl.nepapp.features.dashboard.impl

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import pl.nepapp.features.dashboard.DashboardDirection
import pl.nepapp.features.dashboard.DashboardScreenRegistry
import pl.nepapp.features.login.LoginDirection
import pl.nepapp.features.login.LoginScreenRegistry
import pl.nepapp.navigation.impl.LocalNavigator

val dashboardModule = module {
    factoryOf<DashboardScreenRegistry>(::DashboardScreen)
}


class DashboardScreen: DashboardScreenRegistry() {
    @Composable
    override fun Content() {
        DashboardContent()
    }
}



@Composable
internal fun DashboardContent(modifier: Modifier = Modifier) {
    val navigator = LocalNavigator.current
    Box(Modifier.background(Color.Blue).fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            navigator?.push(LoginDirection)
        }) {
            Text("klikaj mnie")
        }
    }
}