package pl.nepapp.features.todolist.impl

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import pl.nepapp.core.navigation.LocalNavigator
import pl.nepapp.coreui.NepAppScaffold
import pl.nepapp.coreui.NepAppSnackBarHost
import pl.nepapp.coreui.extensions.currentOrThrow
import pl.nepapp.coreui.statemanagement.FullscreenCombinedAsyncHandler
import pl.nepapp.features.tododetails.TodoDetailsDirection


@Composable
fun TodoListContent(viewModel: TodoListViewModel = koinViewModel()) {
    val navigator = LocalNavigator.currentOrThrow
    val state by viewModel.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    NepAppScaffold(
        snackbarHost = {
            NepAppSnackBarHost(snackbarHostState)
        }
    ) {
        FullscreenCombinedAsyncHandler(
            localState = state.todoListLocal,
            remoteState = state.todoListRequest,
            onRetryAction = viewModel::again,
            snackbarHostState = snackbarHostState
        ) { state ->
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state) {
                    Column(modifier = Modifier
                        .clickable {
                            navigator.push(TodoDetailsDirection(it))
                           // navigator.push(TodoDetailsDirection(it))
                        }
                        .fillMaxWidth()
                        .height(60.dp)) {
                        Text(it.title)
                    }
                }
            }
        }

    }
}