package pl.nepapp.features.todolist.impl

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pl.nepapp.core.navigation.LocalNavigator
import pl.nepapp.coreui.NepAppScaffold
import pl.nepapp.coreui.buttons.NepAppPrimaryButton
import pl.nepapp.features.tododetails.TodoDetailsDirection


@Composable
fun TodoListContent() {
    val navigator = LocalNavigator.current

    NepAppScaffold {
        Box(modifier = Modifier.background(Color.Gray)) {

            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                NepAppPrimaryButton(onClick = {
                    navigator?.push(TodoDetailsDirection("jakis fajny id"))
                }, title = "Klikaj")
            }
        }
    }
}