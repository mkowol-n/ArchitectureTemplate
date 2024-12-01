package pl.nepapp.coreui.statemanagement

import androidx.compose.animation.Crossfade
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import pl.nepapp.core.statemanagement.Async
import pl.nepapp.core.statemanagement.Fail
import pl.nepapp.core.statemanagement.Loading
import pl.nepapp.core.statemanagement.Uninitialized

/**
 * Adds a fullscreen handler for whole [Async] states.
 * This handler is specialized for components that should take whole available space.
 * Fullscreen components are basically "fillMaxSize"
 *
 * @param state State to be handled
 * @param onRetryAction Handler for "try again" click
 * @param error Component for error state. Defaults to [FullscreenError]
 * @param loading Component for loading state. Defaults to [FullScreenLoading]
 * @param uninitialized Component for uninitialized state. Defaults to [FullScreenLoading]
 * @param success Component for success state
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> FullscreenAsyncHandler(
    state: Async<T>,
    onRetryAction: () -> Unit,
    error: @Composable (Throwable) -> Unit = { FullscreenError(onRetry = onRetryAction) },
    loading: @Composable () -> Unit = { FullScreenLoading() },
    uninitialized: @Composable () -> Unit = loading,
    success: @Composable (T) -> Unit,
) {
    val pullToRefreshState = rememberPullToRefreshState()

    LaunchedEffect(state) {
        if (state !is Loading || state() == null) {
            pullToRefreshState.animateToHidden()
        }
    }

    RefreshBox(
        pullToRefreshState = pullToRefreshState,
        enabled = state !is Loading,
        onRetryAction = onRetryAction,
    ) {
        Crossfade(targetState = state, label = "") {
            when {
                it() != null -> success(requireNotNull(it()))
                it is Uninitialized -> uninitialized()
                it is Loading -> loading()
                it is Fail -> error(it.error)
            }
        }
    }
}