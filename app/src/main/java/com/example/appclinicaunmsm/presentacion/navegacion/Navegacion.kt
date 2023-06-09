package com.example.appclinicaunmsm.presentacion.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.presentacion.vistas.especialidades.VistaEspecialidades
import com.example.appclinicaunmsm.presentacion.vistas.inicio.VistaInicio
import com.example.appclinicaunmsm.presentacion.vistas.login.VistaLogin
import com.example.appclinicaunmsm.presentacion.vistas.registro.VistaRegistro

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Vista.Login.route) {
        composable(Vista.Login.route) { VistaLogin( navController = navController ) }
        composable(Vista.Registro.route) { VistaRegistro(navController = navController) }
        composable(Vista.Inicio.route) { VistaInicio(navController = navController) }
        composable(Vista.Especialidades.route) { VistaEspecialidades(navController = navController) }
    }
}