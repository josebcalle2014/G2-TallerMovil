package com.example.appclinicaunmsm.presentacion.vistas.inicio

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.dominio.viewModel.NoticiaViewModel
import com.example.appclinicaunmsm.presentacion.global.barras.EnvolvedorBarras
import com.example.appclinicaunmsm.presentacion.global.componentes.Seccion

@Composable
fun VistaInicio(navController: NavController) {
    EnvolvedorBarras (navController = navController) {
        Inicio(navController = navController, noticiaViewModel = NoticiaViewModel())
    }
}

@Composable
fun Inicio(navController: NavController, noticiaViewModel: NoticiaViewModel) {
    val title  = "Noticias"
    val noticias = noticiaViewModel.state

    Seccion(title, noticias)
}

@Preview
@Composable
fun PreviewVistaInicio() {
    VistaInicio(navController = rememberNavController())
}