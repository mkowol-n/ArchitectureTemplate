package pl.nepapp.coreui.statemanagement

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import pl.nepapp.core.statemanagement.Async
import pl.nepapp.core.statemanagement.Loading

@Composable
fun <T> OverlayAsyncHandler(
    state: Async<T>,
    modifier: Modifier = Modifier,
    loading: @Composable () -> Unit = {
        FullScreenLoading(
            modifier = Modifier.alpha(0.8f).background(
                color = Color.White,
            )
        )
    },
    content: @Composable () -> Unit,
) {
    Box(modifier = modifier) {
        content()
        AnimatedVisibility(visible = state is Loading, enter = fadeIn(), exit = fadeOut()) {
            loading()
        }
    }
}