package com.example.appclinicaunmsm.presentacion.vistas.especialidades

import android.content.res.Configuration
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.presentacion.global.barras.EnvolvedorBarras
import com.example.appclinicaunmsm.presentacion.global.componentes.IndicadorDeCarga
import com.example.appclinicaunmsm.presentacion.global.componentes.Seccion
import com.example.appclinicaunmsm.presentacion.tema.AppClinicaUnmsmTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
fun VistaEspecialidades(navController: NavController) {
    EnvolvedorBarras(navController = navController) {
        Especialidades(navController = navController)
    }
}

@Composable
fun Especialidades(navController: NavController, viewModel: EspecialidadesViewModel = hiltViewModel()) {
    val title = "Especialidades"
    val state = viewModel.state
    val eventFlow = viewModel.eventFlow
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        eventFlow.collectLatest { event ->
            when(event) {
                is EspecialidadesViewModel.UIEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    if (state.isLoading) IndicadorDeCarga()
    Seccion(title, state.especialidades)
}

@Composable
@Preview(name = "Modo Claro")
@Preview(name = "Modo Oscuro", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewVistaCitas() {
    AppClinicaUnmsmTheme {
        VistaEspecialidades(navController = rememberNavController())
    }
}