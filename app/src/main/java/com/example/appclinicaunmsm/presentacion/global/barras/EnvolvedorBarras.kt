package com.example.appclinicaunmsm.presentacion.global.barras

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.example.appclinicaunmsm.presentacion.navegacion.Vista

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