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
import pl.nepapp.features.dashboard.DashboardDirection
import pl.nepapp.navigation.LocalNavigator


@Composable
fun LoginScreen(viewModel: LoginViewModel = koinViewModel()) {
    val navigator = LocalNavigator.current
    Box(Modifier.background(Color.Red).fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
           // viewModel.test()
            navigator?.push(DashboardDirection)
        }) {
            Text("klikaj mnie")
            Text("klikaj mnie")
        }
    }
}