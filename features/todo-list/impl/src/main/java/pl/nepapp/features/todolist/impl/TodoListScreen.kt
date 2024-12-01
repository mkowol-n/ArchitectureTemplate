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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.currentKoinScope
import org.koin.compose.getKoin
import org.koin.compose.koinInject
import org.koin.compose.scope.KoinScope
import org.koin.compose.scope.rememberKoinScope
import org.koin.core.Koin
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.StringQualifier
import org.koin.core.qualifier.named
import org.koin.core.qualifier.qualifier
import org.koin.core.scope.Scope
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