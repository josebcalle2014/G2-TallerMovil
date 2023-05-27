package com.example.helloworldcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Color.DarkGray,
    onBackground = Color.White,
)

private val LightColorPalette = lightColors(
    primary = Blue600,
    primaryVariant = Blue900,
    secondary = LightBlue200,
    background = Color.White,
    surface = Gray100,

    onBackground = Gray800,
    onPrimary = Gray100,
    onSecondary = Gray800,
    onSurface = Gray800,
)

@Composable
fun AppClinicaUnmsmTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}