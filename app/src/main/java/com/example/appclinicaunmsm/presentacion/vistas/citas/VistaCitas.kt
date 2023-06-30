package com.example.appclinicaunmsm.presentacion.vistas.citas

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.dominio.model.Cita
import com.example.appclinicaunmsm.presentacion.global.barras.EnvolvedorBarras
import com.example.appclinicaunmsm.presentacion.global.componentes.Seccion
import com.example.appclinicaunmsm.presentacion.tema.AppClinicaUnmsmTheme

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
        Cita("Cita 1", "Descripcion 1", "img1"),
        Cita("Cita 2", "Descripcion 2", "img2"),
        Cita("Cita 3", "Descripcion 3", "img3"),
        Cita("Cita 4", "Descripcion 4", "img4"),
    )
    Seccion(title, items)
}

@Composable
@Preview(name = "Modo Claro")
@Preview(name = "Modo Oscuro", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewVistaCitas() {
    AppClinicaUnmsmTheme {
        VistaCitas(navController = rememberNavController())
    }
}