package pl.nepapp.features.todo_details.impl

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
internal fun TodoDetailsContent() {
    val navigator = LocalNavigator.current
    Box(Modifier.background(Color.Green).fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {

        }) {
            Text("klikaj mnie")
        }
    }
}