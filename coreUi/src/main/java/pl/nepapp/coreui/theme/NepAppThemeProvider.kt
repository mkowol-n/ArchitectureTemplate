package pl.tauron.mtauron.composeUi.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import pl.nepapp.coreui.theme.TauronColors
import pl.nepapp.coreui.theme.materialColors
import pl.nepapp.coreui.theme.lightColors

@Composable
fun TauronThemeProvider(
    content: @Composable () -> Unit
) {
    val colors by remember {
        mutableStateOf(lightColors)
    }

    MaterialTheme(
        colorScheme = materialColors(colors),
    ) {
        CompositionLocalProvider(
            localTauronColors provides colors,
        ) {
            Surface(
                color = colors.background,
                content = content
            )
        }
    }
}

private val localTauronColors = staticCompositionLocalOf<TauronColors> {
    error("No TauronColors provided")
}

object TauronTheme {
    val colors: TauronColors
        @Composable
        @ReadOnlyComposable
        get() = localTauronColors.current

    val typography: NepAppTypography
        get() = NepAppTypography
}