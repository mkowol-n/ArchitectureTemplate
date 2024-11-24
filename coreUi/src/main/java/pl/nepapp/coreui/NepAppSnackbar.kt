package pl.nepapp.coreui

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

suspend fun SnackbarHostState.showFetchFailed() {
    this.showSnackbar(
        message = "Fetch failed",
        withDismissAction = true,
        duration = SnackbarDuration.Indefinite
    )
}

@Composable
fun NepAppSnackBarHost(snackbarHostState: SnackbarHostState) {
    SnackbarHost(
        hostState = snackbarHostState
    ) {
        Snackbar(
            contentColor = Color.White,
            snackbarData = it,
            containerColor = Color.Red
        )
    }
}