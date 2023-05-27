package com.example.appclinicaunmsm.presentacion.global.bar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.example.appclinicaunmsm.presentacion.navigation.Screen

@Composable
fun BarsWrapper(navController: NavController, content: @Composable (PaddingValues) -> Unit) {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    Scaffold(topBar = { TopBar(navController) }, content = content, bottomBar = {
        BottomBar(currentScreen = currentScreen, onScreenSelected = { screen ->
            currentScreen = screen
            navigateToScreen(navController, screen)
        })
    })
}

private fun navigateToScreen(navController: NavController, screen: Screen) {
    val currentBackStackEntry = navController.currentBackStackEntry
    val currentDestination = currentBackStackEntry?.destination

    if (currentDestination?.route != screen.route) {
        navController.navigate(screen.route) {
            popUpTo(currentDestination?.id ?: -1) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
}