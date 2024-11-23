package pl.nepapp.features.tododetails.impl

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel
import pl.nepapp.core.navigation.LocalNavigator
import pl.nepapp.features.login.LoginDirection


@Composable
fun TodoDetailsScreen(
    viewModel: TodoDetailsViewModel = koinViewModel()
) {
    val navigator = LocalNavigator.current

    Scaffold {
        Box(modifier = Modifier.padding(it)) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Button(onClick = {
                    navigator?.parent!!.push(LoginDirection)
                }) {
                    Text("klikaj mnie")
                    Text("klikaj mnie")
                }
            }
        }
    }
}