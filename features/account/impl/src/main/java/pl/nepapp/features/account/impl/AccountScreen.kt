package pl.nepapp.features.account.impl

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.koin.core.annotation.Factory
import pl.nepapp.features.account.AccountScreenRegistry
import pl.nepapp.navigation.impl.LocalNavigator

@Factory
class AccountScreen: AccountScreenRegistry() {
    @Composable
    override fun Content() {
        AccountContent()
    }
}

@Composable
internal fun AccountContent() {
    val navigator = LocalNavigator.current
    Box(Modifier.background(Color.Black).fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {

        }) {
            Text("klikaj mnie")
        }
    }
}