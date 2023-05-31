package com.example.appclinicaunmsm.presentacion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.dominio.viewModel.LoginViewModel
import com.example.appclinicaunmsm.presentacion.citas.VistaCitas
import com.example.appclinicaunmsm.presentacion.inicio.VistaInicio
import com.example.appclinicaunmsm.presentacion.login.LoginScreen
import com.example.appclinicaunmsm.presentacion.register.RegisterScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(
                navController = navController, viewModel = LoginViewModel()
            )
        }
        composable(Screen.Register.route) { RegisterScreen(navController = navController) }
        composable(Screen.Home.route) { VistaInicio(navController = navController) }
        composable(Screen.Appointment.route) { VistaCitas(navController = navController) }
    }
}