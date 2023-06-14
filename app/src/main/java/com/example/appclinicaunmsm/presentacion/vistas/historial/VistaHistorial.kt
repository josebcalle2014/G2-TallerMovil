package com.example.appclinicaunmsm.presentacion.vistas.historial

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.dominio.model.historialModelos.Historial
import com.example.appclinicaunmsm.presentacion.global.barras.EnvolvedorBarras
import com.example.appclinicaunmsm.presentacion.global.componentes.Seccion
import com.example.appclinicaunmsm.presentacion.tema.AppClinicaUnmsmTheme

@Composable
fun VistaHistorial(navController: NavController) {
    EnvolvedorBarras (navController = navController) {
        Historiales(navController = navController)
    }
}

@Composable
fun Historiales(navController: NavController) {
    val title  = "Historia Clínica"
    val items = listOf(
        Historial("Cardiologia", "Fecha: 01/01/2000", "img2"),
        Historial("Medicina general", "Fecha: 01/01/2000", "img3"),
        Historial("Radiología", "Fecha: 01/01/2000", "img1"),
    )
    Seccion(title, items)
}

@Composable
@Preview(name = "Modo Claro")
@Preview(name = "Modo Oscuro", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewVistaHistorial() {
    AppClinicaUnmsmTheme() {
        VistaHistorial(navController = rememberNavController())
    }
}
