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
import pl.nepapp.features.dashboard.DashboardScreen
import pl.nepapp.features.login.LoginScreen
import pl.nepapp.navigation.impl.LocalNavigator
import pl.nepapp.navigation.impl.ScreenRegister

object LoginScreenActual: ScreenRegister<LoginScreen>() {
    @Composable
    override fun Content() {
        Test2()
    }
}

@Composable
fun Test2(modifier: Modifier = Modifier) {
    val navigator = LocalNavigator.current
    Box(Modifier.background(Color.Red).fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            navigator?.push(DashboardScreen)
        }) {
            Text("klikaj mnie")
        }

    }
}