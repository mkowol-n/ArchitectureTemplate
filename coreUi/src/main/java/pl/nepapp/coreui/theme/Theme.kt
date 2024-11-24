package pl.nepapp.coreui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf


private val lightColors = NepAppColors(
    primary = colorPrimary,
    funColor = funColor
)

private val darkColors = NepAppColors(
    primary = colorPrimary,
    funColor = funColorDarkTheme
)


fun materialColors(colors: NepAppColors) = lightColorScheme(
    primary = colors.primary,
)


@Composable
fun NepAppThemeProvider(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) darkColors else lightColors
        }

        darkTheme -> darkColors
        else -> lightColors
    }

    MaterialTheme(
        colorScheme = materialColors(colorScheme),
        typography = Typography,
    ) {
        CompositionLocalProvider(
            LocalNepAppColors provides colorScheme,
            content = content
        )
    }
}

object NepAppTheme {
    val colors: NepAppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalNepAppColors.current

    val typography = Typography
}

private val LocalNepAppColors = staticCompositionLocalOf<NepAppColors> {
    error("No GoonColors provided")
}