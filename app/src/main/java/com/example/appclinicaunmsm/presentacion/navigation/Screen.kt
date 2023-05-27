package com.example.appclinicaunmsm.presentacion.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector) {
    object Login: Screen("Login", Icons.Outlined.Info)
    object Register: Screen("Register", Icons.Outlined.Info)

    object Home : Screen("Inicio", Icons.Outlined.Home)
    object Appointment : Screen("Citas", Icons.Outlined.AccountCircle)
    object History : Screen("Inicio", Icons.Outlined.Info)
    object Settings : Screen("Inicio", Icons.Outlined.Settings)
}