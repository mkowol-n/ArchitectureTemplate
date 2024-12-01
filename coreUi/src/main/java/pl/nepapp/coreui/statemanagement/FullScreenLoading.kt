package pl.nepapp.coreui.statemanagement

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun FullScreenLoading(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.pointerInput(Unit) {}.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}