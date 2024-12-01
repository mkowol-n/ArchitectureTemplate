package pl.nepapp.coreui.statemanagement

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import pl.nepapp.core.statemanagement.Async
import pl.nepapp.core.statemanagement.Fail
import pl.nepapp.core.statemanagement.Loading
import pl.nepapp.core.statemanagement.Success
import pl.nepapp.coreui.showFetchFailed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> FullscreenCombinedAsyncHandler(
    remoteState: Async<Unit>,
    localState: Async<T>,
    onRetryAction: () -> Unit,
    snackbarHostState: SnackbarHostState,
    error: @Composable (Throwable) -> Unit = { FullscreenError(onRetry = onRetryAction) },
    loading: @Composable () -> Unit = { FullScreenLoading() },
    success: @Composable (T) -> Unit,
) {
    val pullToRefreshState = rememberPullToRefreshState()

    LaunchedEffect(remoteState) {
        if (remoteState is Loading) {
            pullToRefreshState.animateToHidden()
        }
    }

    LaunchedEffect(remoteState) {
        if (remoteState is Fail && localState is Success) {
            snackbarHostState.showFetchFailed()
        }
    }

    RefreshBox(
        enabled = remoteState !is Loading,
        onRetryAction = onRetryAction,
        pullToRefreshState = pullToRefreshState,
    ) {
        Column {
            AnimatedVisibility(
                modifier = Modifier.fillMaxWidth(),
                visible = remoteState is Loading && localState is Success
            ) {
                LinearProgressIndicator()
            }
            Crossfade(localState, label = "") { local ->
                when {
                    local() != null -> success(requireNotNull(local()))
                    else -> {
                        Crossfade(targetState = remoteState, label = "") { remote ->
                            when {
                                remote is Fail -> error(remote.error)
                                else -> loading()
                            }
                        }
                    }
                }
            }
        }
    }
}