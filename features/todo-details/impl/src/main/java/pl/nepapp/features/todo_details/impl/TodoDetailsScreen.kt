package pl.nepapp.features.todo_details.impl

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.koin.androidx.compose.koinViewModel
import org.koin.core.annotation.Factory
import pl.nepapp.features.login.LoginDirection
import pl.nepapp.features.todo_details.TodoDetailsDirection
import pl.nepapp.features.todo_details.TodoDetailsScreenRegistry
import pl.nepapp.navigation.impl.LocalNavigator

@Factory
class TodoDetailsScreen: TodoDetailsScreenRegistry() {
    @Composable
    override fun Content() {
        TodoDetailsContent()
    }
}

@Composable
internal fun TodoDetailsContent(viewModel: TodoDetailsViewModel = koinViewModel()) {
    val navigator = LocalNavigator.current
    Scaffold {
        Box(modifier = Modifier.padding(it)) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Button(onClick = {
                    navigator!!.parent.push(LoginDirection)
                }) {
                    Text("klikaj mnie")
                }
            }
        }
    }
}