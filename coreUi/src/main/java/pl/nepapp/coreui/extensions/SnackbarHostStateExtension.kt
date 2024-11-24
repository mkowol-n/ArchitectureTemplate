package pl.nepapp.coreui.extensions

import androidx.compose.material3.SnackbarHostState

suspend fun SnackbarHostState.showRemoteSourceFailed() {
    this.showSnackbar(
        message = "Failed to fetch newestData",
        withDismissAction = true,
    )
}