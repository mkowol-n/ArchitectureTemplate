package pl.nepapp.features.login.impl

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.koin.androidx.compose.koinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import pl.nepapp.features.dashboard.DashboardDirection
import pl.nepapp.features.login.LoginScreenRegistry
import pl.nepapp.navigation.impl.LocalNavigator

@Factory
class LoginScreen: LoginScreenRegistry() {
    @Composable
    override fun Content() {
        LoginContent()
    }
}

@Composable
fun LoginContent(viewModel: LoginViewModel = koinViewModel()) {
    val navigator = LocalNavigator.current
    Box(Modifier.background(Color.Red).fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
           // viewModel.test()
            navigator?.push(DashboardDirection)
        }) {
            Text("klikaj mnie")
        }
    }
}