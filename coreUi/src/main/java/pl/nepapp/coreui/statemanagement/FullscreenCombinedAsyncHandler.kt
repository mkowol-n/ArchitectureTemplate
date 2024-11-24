package pl.nepapp.coreui.statemanagement

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import pl.nepapp.core.statemanagement.Async
import pl.nepapp.core.statemanagement.Fail
import pl.nepapp.core.statemanagement.Loading
import pl.nepapp.core.statemanagement.Uninitialized
import pl.nepapp.coreui.showFetchFailed

@Composable
fun <T> FullscreenCombinedAsyncHandler(
    remoteState: Async<Unit>,
    localState: Async<T>,
    onRetryAction: () -> Unit,
    snackbarHostState: SnackbarHostState,
    error: @Composable (Throwable) -> Unit = { FullscreenError(onRetry = onRetryAction) },
    loading: @Composable () -> Unit = { FullScreenLoading() },
    uninitialized: @Composable () -> Unit = loading,
    success: @Composable (T) -> Unit,
) {
    LaunchedEffect(remoteState) {
        if(remoteState is Fail) {
            snackbarHostState.showFetchFailed()
        }
    }
    Column {
        AnimatedVisibility(modifier = Modifier.fillMaxWidth(), visible = remoteState is Loading) {
            LinearProgressIndicator()
        }
        Crossfade(localState, label = "") { local ->
            when {
                local() != null -> success(requireNotNull(local()))
                local is Uninitialized -> uninitialized()
                local is Loading -> loading()
                local is Fail -> error(local.error)
            }
        }
    }
}