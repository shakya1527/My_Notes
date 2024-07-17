package com.shakya.mynotes.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

val lightColorScheme = ColorScheme(
    background = Color(0xfff1fdf0),
    error = Color(0xffba1a1a),
    errorContainer = Color(0xffffdad6),
    inverseOnSurface = Color(0xffe8f4e8),
    inversePrimary = Color(0xff00e38a),
    inverseSurface = Color(0xff28332b),
    onBackground = Color(0xff141e17),
    onError = Color(0xffffffff),
    onErrorContainer = Color(0xff410002),
    onPrimary = Color(0xffffffff),
    onPrimaryContainer = Color(0xff002110),
    onSecondary = Color(0xffffffff),
    onSecondaryContainer = Color(0xff002118),
    onSurface = Color(0xff141e17),
    onSurfaceVariant = Color(0xff3c4a40),
    onTertiary = Color(0xffffffff),
    onTertiaryContainer = Color(0xff00201d),
    outline = Color(0xff6c7b6f),
    outlineVariant = Color(0xffacc5b6),
    primary = Color(0xff006d40),
    primaryContainer = Color(0xff56ffa7),
    scrim = Color(0xff000000),
    secondary = Color(0xff3c6658),
    secondaryContainer = Color(0xffbfecda),
    surface = Color(0xfff1fdf0),
    surfaceTint = Color(0xff006d40),
    surfaceVariant = Color(0xffd7e7d8),
    tertiary = Color(0xff1c6962),
    tertiaryContainer = Color(0xffa8f0e7),
    surfaceBright = Color(0xfff1fdf0),
    surfaceDim = Color(0xffd1ddd2),
    surfaceContainer = Color(0xffe5f1e5),
    surfaceContainerHigh = Color(0xffdfebdf),
    surfaceContainerHighest = Color(0xffdae6da),
    surfaceContainerLow = Color(0xffebf7eb),
    surfaceContainerLowest = Color(0xffffffff),
)

val darkColorScheme = ColorScheme(
    background = Color(0xff0c160f),
    error = Color(0xffffb4ab),
    errorContainer = Color(0xff93000a),
    inverseOnSurface = Color(0xff28332b),
    inversePrimary = Color(0xff006d40),
    inverseSurface = Color(0xffdae6da),
    onBackground = Color(0xffdae6da),
    onError = Color(0xff690005),
    onErrorContainer = Color(0xffffdad6),
    onPrimary = Color(0xff00391f),
    onPrimaryContainer = Color(0xff56ffa7),
    onSecondary = Color(0xff09372b),
    onSecondaryContainer = Color(0xffbfecda),
    onSurface = Color(0xffdae6da),
    onSurfaceVariant = Color(0xffbbcabd),
    onTertiary = Color(0xff003733),
    onTertiaryContainer = Color(0xffa8f0e7),
    outline = Color(0xff859488),
    outlineVariant = Color(0xff2f5242),
    primary = Color(0xff00e38a),
    primaryContainer = Color(0xff00522f),
    scrim = Color(0xff000000),
    secondary = Color(0xffa3d0bf),
    secondaryContainer = Color(0xff244e41),
    surface = Color(0xff0c160f),
    surfaceTint = Color(0xff00e38a),
    surfaceVariant = Color(0xff3c4a40),
    tertiary = Color(0xff8dd3cb),
    tertiaryContainer = Color(0xff00504a),
    surfaceBright = Color(0xff313c34),
    surfaceDim = Color(0xff0c160f),
    surfaceContainer = Color(0xff18221b),
    surfaceContainerHigh = Color(0xff222c25),
    surfaceContainerHighest = Color(0xff2d372f),
    surfaceContainerLow = Color(0xff141e17),
    surfaceContainerLowest = Color(0xff07100a),
)

@Composable
fun MyNotesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}