package com.example.appclinicaunmsm.presentacion.vistas.inicio

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.data.repositorio.NoticiaRepositorioImp
import com.example.appclinicaunmsm.dominio.caso_uso.GetNoticiasUseCase
import com.example.appclinicaunmsm.presentacion.global.barras.EnvolvedorBarras
import com.example.appclinicaunmsm.presentacion.global.componentes.Seccion
import com.example.appclinicaunmsm.presentacion.tema.AppClinicaUnmsmTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
fun VistaInicio(navController: NavController) {
    EnvolvedorBarras (navController = navController) {
        Inicio(navController = navController, InicioViewModel(
            GetNoticiasUseCase(repositorio = NoticiaRepositorioImp())
        )
        )
    }
}

@Composable
fun Inicio(navController: NavController, viewModel: InicioViewModel) {
    val title  = "Servicios"
    val state = viewModel.state
    val eventFlow = viewModel.eventFlow
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        eventFlow.collectLatest { event ->
            when(event) {
                is InicioViewModel.UIEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }
    Seccion(title, state.noticias)
    if (state.isLoading) FullScreenLoading()
}

@Composable
private fun FullScreenLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator()
    }
}

@Composable
@Preview(name = "Modo Claro")
@Preview(name = "Modo Oscuro", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewVistaInicio() {
    AppClinicaUnmsmTheme {
        VistaInicio(navController = rememberNavController())
    }
}