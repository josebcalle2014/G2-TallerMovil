package com.example.appclinicaunmsm.presentacion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.dominio.viewModel.LoginViewModel
import com.example.appclinicaunmsm.presentacion.home.HomeScreen
import com.example.appclinicaunmsm.presentacion.login.LoginScreen
import com.example.appclinicaunmsm.presentacion.register.RegisterScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.LOGIN_SCREEN.route) {
        composable(AppScreens.LOGIN_SCREEN.route) {
            LoginScreen(
                navController = navController,
                viewModel = LoginViewModel()
            )
        }
        composable(AppScreens.REGISTER_SCREEN.route) { RegisterScreen(navController = navController) }
        composable(AppScreens.HOME_SCREEN.route) { HomeScreen(navController = navController)}
    }
}