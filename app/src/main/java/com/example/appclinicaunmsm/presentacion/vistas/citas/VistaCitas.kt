package com.example.appclinicaunmsm.presentacion.vistas.citas

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.dominio.model.Appointment
import com.example.appclinicaunmsm.presentacion.global.barras.EnvolvedorBarras
import com.example.appclinicaunmsm.presentacion.global.componentes.Seccion

@Composable
fun VistaCitas(navController: NavController) {
    EnvolvedorBarras (navController = navController) {
        Citas(navController = navController)
    }
}

@Composable
fun Citas(navController: NavController) {
    val title  = "Citas"
    val items = listOf(
        Appointment("Cita 1", "Descripcion 1", "img1"),
        Appointment("Cita 2", "Descripcion 2", "img2"),
        Appointment("Cita 3", "Descripcion 3", "img3"),
        Appointment("Cita 4", "Descripcion 4", "img4"),
    )
    Seccion(title, items)
}

@Composable
@Preview
fun PreviewVistaCitas() {
    VistaCitas(navController = rememberNavController())
}