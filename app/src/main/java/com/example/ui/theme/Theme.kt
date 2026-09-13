package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = lightColorScheme(
    primary = LogoPink,
    onPrimary = Color.White,
    primaryContainer = LogoPinkLight,
    onPrimaryContainer = LogoPinkDark,
    secondary = CzechBlue,
    onSecondary = Color.White,
    secondaryContainer = CzechBlueLight,
    onSecondaryContainer = CzechBlueDark,
    tertiary = LogoYellow,
    onTertiary = DoodleBlack,
    tertiaryContainer = LogoYellowLight,
    onTertiaryContainer = LogoYellowDark,
    background = Color.White,
    onBackground = DoodleBlack,
    surface = Color.White,
    onSurface = DoodleDark,
    surfaceVariant = LogoPinkSoft,
    onSurfaceVariant = DoodleMuted,
    outline = CanvasBorder
)

private val LightColorScheme = lightColorScheme(
    primary = LogoPink,
    onPrimary = Color.White,
    primaryContainer = LogoPinkLight,
    onPrimaryContainer = LogoPinkDark,
    secondary = CzechBlue,
    onSecondary = Color.White,
    secondaryContainer = CzechBlueLight,
    onSecondaryContainer = CzechBlueDark,
    tertiary = LogoYellow,
    onTertiary = DoodleBlack,
    tertiaryContainer = LogoYellowLight,
    onTertiaryContainer = LogoYellowDark,
    background = Color.White,
    onBackground = DoodleBlack,
    surface = Color.White,
    onSurface = DoodleDark,
    surfaceVariant = LogoPinkSoft,
    onSurfaceVariant = DoodleMuted,
    outline = CanvasBorder
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
