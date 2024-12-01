package pl.nepapp.coreui.statemanagement

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RefreshBox(
    enabled: Boolean,
    onRetryAction: () -> Unit,
    pullToRefreshState: PullToRefreshState,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier.pullToRefresh(
            state = pullToRefreshState,
            enabled = enabled,
            onRefresh = onRetryAction,
            isRefreshing = false,
        )
    ) {
        content()
        Indicator(
            modifier = Modifier.align(Alignment.TopCenter),
            isRefreshing = false,
            state = pullToRefreshState,
            containerColor = Color.White,
            color = Color.Red
        )
    }
}