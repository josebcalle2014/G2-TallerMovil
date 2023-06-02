package com.example.appclinicaunmsm.presentacion.global.barras

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.presentacion.navegacion.Vista
import com.example.appclinicaunmsm.presentacion.tema.AppClinicaUnmsmTheme

@Composable
fun EnvolvedorBarras(navController: NavController, content: @Composable (PaddingValues) -> Unit) {
    var vistaActual by remember { mutableStateOf<Vista>(Vista.Inicio) }

    Scaffold(topBar = { BarraSuperior(navController) }, content = content, bottomBar = {
        BarraInferior(vistaActual = vistaActual, onScreenSelected = { screen ->
            vistaActual = screen
            NavegarAVista(navController, screen)
        })
    })
}

private fun NavegarAVista(navController: NavController, vista: Vista) {
    val currentBackStackEntry = navController.currentBackStackEntry
    val currentDestination = currentBackStackEntry?.destination

    if (currentDestination?.route != vista.route) {
        navController.navigate(vista.route) {
            popUpTo(currentDestination?.id ?: -1) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
}

@Composable
@Preview(name = "Modo Claro")
@Preview(name = "Modo Oscuro", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewEnvolvedorBarras() {
    AppClinicaUnmsmTheme {
        EnvolvedorBarras(navController = rememberNavController()) {
            Column(modifier = Modifier.fillMaxSize()) {}
        }
    }
}
