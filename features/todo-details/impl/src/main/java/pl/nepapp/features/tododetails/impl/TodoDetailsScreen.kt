package pl.nepapp.features.tododetails.impl

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import pl.nepapp.core.navigation.LocalNavigator
import pl.nepapp.coreui.NepAppScaffold
import pl.nepapp.features.login.LoginDirection


@Composable
fun TodoDetailsScreen(
    viewModel: TodoDetailsViewModel = koinViewModel()
) {
    val state by viewModel.collectAsState()

    NepAppScaffold {
        Column {
            Text(state.directionModel.todo.id)
            Text(state.directionModel.todo.title)
            Text(state.directionModel.todo.description)
        }
    }
}