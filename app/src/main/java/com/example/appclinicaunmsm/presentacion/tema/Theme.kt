package com.example.appclinicaunmsm.presentacion.tema

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DarkColorPalette = darkColors(
    primary = Blue800,
    primaryVariant = Blue900,
    secondary = LightBlue400,
    background = DarkBlue400,
    surface = DarkGray400,

    onBackground = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onSurface = Color.White
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