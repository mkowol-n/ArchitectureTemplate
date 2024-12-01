package pl.nepapp.features.tododetails.impl

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.scope.KoinScope
import org.orbitmvi.orbit.compose.collectAsState
import pl.nepapp.core.common.SomeOtherScope
import pl.nepapp.coreui.NepAppScaffold


@Composable
fun TodoDetailsScreen(
) {

    KoinScope<SomeOtherScope>(scopeID = "SomeOtherScope") {
        val viewModel: TodoDetailsViewModel = koinViewModel()
        val state by viewModel.collectAsState()

        NepAppScaffold {
            Column {
                Text(state.directionModel.todo.id)
                Text(state.directionModel.todo.title)
                Text(state.directionModel.todo.description)
            }
        }
    }
}