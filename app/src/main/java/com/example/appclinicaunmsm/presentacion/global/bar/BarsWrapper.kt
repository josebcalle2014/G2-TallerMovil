package com.example.appclinicaunmsm.presentacion.global.bar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.example.appclinicaunmsm.presentacion.navigation.Vista

@Composable
fun BarsWrapper(navController: NavController, content: @Composable (PaddingValues) -> Unit) {
    var vistaActual by remember { mutableStateOf<Vista>(Vista.Inicio) }

    Scaffold(topBar = { TopBar(navController) }, content = content, bottomBar = {
        BottomBar(vistaActual = vistaActual, onScreenSelected = { screen ->
            vistaActual = screen
            navigateToScreen(navController, screen)
        })
    })
}

private fun navigateToScreen(navController: NavController, vista: Vista) {
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