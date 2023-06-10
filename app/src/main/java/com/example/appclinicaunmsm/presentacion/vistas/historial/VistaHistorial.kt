package com.example.appclinicaunmsm.presentacion.vistas.historial

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.dominio.model.historialModelos.Historial
import com.example.appclinicaunmsm.presentacion.global.barras.EnvolvedorBarras
import com.example.appclinicaunmsm.presentacion.global.componentes.Seccion

@Composable
fun VistaHistorial(navController: NavController) {
    EnvolvedorBarras (navController = navController) {
        Historiales(navController = navController)
    }
}

@Composable
fun Historiales(navController: NavController) {
    val title  = "Historial"
    val items = listOf(
        Historial("Historial 1", "Fecha: 01/01/2000", "img1"),
        Historial("Historial 2", "Fecha: 01/01/2000", "img2"),
        Historial("Historial 3", "Fecha: 01/01/2000", "img3"),
        Historial("Historial 4", "Fecha: 01/01/2000", "img4"),
    )
    Seccion(title, items)
}

@Composable
@Preview
fun PreviewVistaHistorial() {
    VistaHistorial(navController = rememberNavController())
}
