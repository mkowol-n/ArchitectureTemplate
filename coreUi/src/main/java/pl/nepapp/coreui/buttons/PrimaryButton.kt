package pl.nepapp.coreui.buttons

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun PrimaryButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    BaseButton(
        modifier = modifier,
        title = title,
        onClick = onClick,
        enabled = enabled,
        textColorEnabled = Color.White,
        textColorDisabled = Color.Black,
        backgroundColorEnabled = Color.Red,
        backgroundColorDisabled = Color.LightGray

    )
}