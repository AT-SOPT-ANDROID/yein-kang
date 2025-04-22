package org.sopt.at.presentation.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext


private val LocalAtSoptColors = staticCompositionLocalOf<AtSoptColors> {
    error("No AtSoptColors provided")
}

object AtSoptTheme {
    val colors: AtSoptColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAtSoptColors.current
}

@Composable
fun ProvideAtSoptColors(
    colors: AtSoptColors,
    content: @Composable () -> Unit
) {
    val provideColors = remember { colors.copy() }
    provideColors.update(colors)

    CompositionLocalProvider(
        LocalAtSoptColors provides provideColors,
        content = content
    )
}

@Composable
fun AtSoptAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = atSoptColors()

    ProvideAtSoptColors(colors = colors) {
        MaterialTheme(
            typography = Typography,
            content = content
        )
    }
}