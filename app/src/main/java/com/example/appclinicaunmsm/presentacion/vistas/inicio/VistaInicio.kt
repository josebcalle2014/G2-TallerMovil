package com.example.appclinicaunmsm.presentacion.vistas.inicio

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.dominio.model.servicioModelos.Servicio
import com.example.appclinicaunmsm.presentacion.global.barras.EnvolvedorBarras
import com.example.appclinicaunmsm.presentacion.global.componentes.Seccion

@Composable
fun VistaInicio(navController: NavController) {
    EnvolvedorBarras (navController = navController) {
        Inicio(navController = navController)
    }
}

@Composable
fun Inicio(navController: NavController) {
    val title  = "Servicios"
    val items = listOf(
        Servicio("Servicio 1", "Descripcion 1", "img1"),
        Servicio("Servicio 2", "Descripcion 2", "img2"),
        Servicio("Servicio 3", "Descripcion 3", "img3"),
    )
    Seccion(title, items)
 }

@Preview
@Composable
fun PreviewVistaInicio() {
    VistaInicio(navController = rememberNavController())
}