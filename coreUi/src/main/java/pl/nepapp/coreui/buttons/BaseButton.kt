package pl.nepapp.coreui.buttons

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
internal fun BaseButton(
    modifier: Modifier,
    title: String,
    onClick: () -> Unit,
    backgroundColorEnabled: Color,
    backgroundColorDisabled: Color,
    textColorEnabled: Color,
    textColorDisabled: Color,
    enabled: Boolean = true,
) {
    val backgroundColor by animateColorAsState(
        if (enabled) backgroundColorEnabled else backgroundColorDisabled,
        label = ""
    )
    val textColor by animateColorAsState(
        if (enabled) textColorEnabled else textColorDisabled,
        label = ""
    )
    Box(
        modifier = modifier
            .background(color = backgroundColor)
            .clickable(onClick = onClick, enabled = enabled)
    ) {
        Text(title, color = textColor)
    }
}