package com.example.appclinicaunmsm.presentacion.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Vista(val route: String, val icon: ImageVector) {
    object Login: Vista("Login", Icons.Outlined.Info)
    object Registro: Vista("Registro", Icons.Outlined.Info)

    object Inicio : Vista("Inicio", Icons.Outlined.Home)
    object Citas : Vista("Citas", Icons.Outlined.AccountCircle)
    object Historial : Vista("Inicio", Icons.Outlined.Info)
    object Perfil : Vista("Inicio", Icons.Outlined.Settings)
}