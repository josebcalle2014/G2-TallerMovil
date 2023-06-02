package com.example.appclinicaunmsm.presentacion.global.barras

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.appclinicaunmsm.presentacion.navegacion.Vista
import com.example.appclinicaunmsm.presentacion.tema.AppClinicaUnmsmTheme

@Composable
fun BarraInferior(
    vistaActual: Vista,
    onScreenSelected: (Vista) -> Unit
) {
    Column {
        BottomNavigation {
            BottomNavigationItem(
                selected = vistaActual == Vista.Inicio,
                onClick = { onScreenSelected(Vista.Inicio) },
                icon = {
                    Icon(
                        imageVector = Vista.Inicio.icon,
                        contentDescription = Vista.Inicio.route
                    )
                },
                label = { Text(text = Vista.Inicio.route) }
            )
            BottomNavigationItem(
                selected = vistaActual == Vista.Citas,
                onClick = { onScreenSelected(Vista.Citas) },
                icon = {
                    Icon(
                        imageVector = Vista.Citas.icon,
                        contentDescription = Vista.Citas.route
                    )
                },
                label = { Text(text = Vista.Citas.route) }
            )
            BottomNavigationItem(
                selected = vistaActual == Vista.Historial,
                onClick = { onScreenSelected(Vista.Historial) },
                icon = {
                    Icon(
                        imageVector = Vista.Historial.icon,
                        contentDescription = Vista.Historial.route
                    )
                },
                label = { Text(text = Vista.Historial.route) }
            )
            BottomNavigationItem(
                selected = vistaActual == Vista.Perfil,
                onClick = { onScreenSelected(Vista.Perfil) },
                icon = {
                    Icon(
                        imageVector = Vista.Perfil.icon,
                        contentDescription = Vista.Perfil.route
                    )
                },
                label = { Text(text = Vista.Perfil.route) }
            )
        }
    }
}

@Composable
@Preview(name = "Modo Claro")
@Preview(name = "Modo Oscuro", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewBarraInferior() {
    AppClinicaUnmsmTheme {
        BarraInferior(vistaActual = Vista.Inicio, onScreenSelected = {})
    }
}