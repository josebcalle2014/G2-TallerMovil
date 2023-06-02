package com.example.appclinicaunmsm.presentacion.vistas.inicio

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.dominio.model.ClinicServices
import com.example.appclinicaunmsm.presentacion.global.barras.EnvolvedorBarras
import com.example.appclinicaunmsm.presentacion.global.componentes.Seccion
import com.example.appclinicaunmsm.presentacion.tema.AppClinicaUnmsmTheme

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
        ClinicServices("Servicio 1", "Descripcion 1", "img1"),
        ClinicServices("Servicio 2", "Descripcion 2", "img2"),
        ClinicServices("Servicio 3", "Descripcion 3", "img3"),
    )
    Seccion(title, items)
 }

@Composable
@Preview(name = "Modo Claro")
@Preview(name = "Modo Oscuro", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewVistaInicio() {
    AppClinicaUnmsmTheme {
        VistaInicio(navController = rememberNavController())
    }
}