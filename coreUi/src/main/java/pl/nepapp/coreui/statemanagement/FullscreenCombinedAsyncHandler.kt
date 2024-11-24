package pl.nepapp.coreui.statemanagement

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import pl.nepapp.core.statemanagement.Async
import pl.nepapp.core.statemanagement.Fail
import pl.nepapp.core.statemanagement.Loading
import pl.nepapp.core.statemanagement.Success
import pl.nepapp.core.statemanagement.Uninitialized

@Composable
fun <T> FullscreenCombinedAsyncHandler(
    remoteState: Async<Unit>,
    localState: Async<T>,
    onRetryAction: () -> Unit,
    error: @Composable (Throwable) -> Unit = { FullscreenError(onRetry = onRetryAction) },
    loading: @Composable () -> Unit = { FullScreenLoading() },
    uninitialized: @Composable () -> Unit = loading,
    success: @Composable (T) -> Unit,
) {
    Crossfade(localState, label = "") { local ->
        if (local is Success) {
            success(requireNotNull(local()))
        } else {
            Crossfade(targetState = remoteState, label = "") { remote ->
                when(remote) {
                    is Uninitialized -> uninitialized()
                    is Loading -> loading()
                    is Fail -> error(remote.error)
                    else -> loading()
                }
            }
        }
    }
}