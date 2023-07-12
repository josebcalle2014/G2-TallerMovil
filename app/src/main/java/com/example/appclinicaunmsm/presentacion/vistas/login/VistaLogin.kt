package com.example.appclinicaunmsm.presentacion.vistas.login

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.R
import com.example.appclinicaunmsm.presentacion.global.formulario.BotonFormulario
import com.example.appclinicaunmsm.presentacion.global.formulario.ContrasenaInput
import com.example.appclinicaunmsm.presentacion.global.formulario.TextoInput
import com.example.appclinicaunmsm.presentacion.global.formulario.TituloFormulario
import com.example.appclinicaunmsm.presentacion.tema.AppClinicaUnmsmTheme
import com.example.appclinicaunmsm.presentacion.vistas.login.componentes.OlvidoContrasenaTexto
import com.example.appclinicaunmsm.presentacion.vistas.login.componentes.RegistrarTexto
import kotlinx.coroutines.flow.collectLatest

@Composable
fun VistaLogin(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {

    //if (UsuarioSingleton.isSesionActiva()) {
    //    navController.navigate(Vista.Inicio.route) {
    //        popUpTo(Vista.Login.route) {
    //            inclusive = true
    //        }
    //    }
    //}

    val state = viewModel.state
    val eventFlow = viewModel.eventFlow
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
                    .padding(innerPadding)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
            ) {

                TituloFormulario(text = stringResource(id = R.string.login_title_form))

                TextoInput(
                    value = state.dni,
                    onValueChange = { viewModel.onLoginChanged(it, state.contrasenia) },
                    placeholder = stringResource(id = R.string.dni_field_form)
                )

                ContrasenaInput(
                    value = state.contrasenia,
                    onValueChange = { viewModel.onLoginChanged(state.dni, it) }
                )

                BotonFormulario(
                    buttonEnabled = state.botonActivo,
                    onClick = { viewModel.onLoginSelected(navController = navController) },
                    text = stringResource(id = R.string.login_button_form)
                )

                OlvidoContrasenaTexto(navController = navController)
                Divider(color = MaterialTheme.colors.onSecondary, thickness = 1.dp)
                RegistrarTexto(navController = navController)
            }
        }
    )

    LaunchedEffect(key1 = true) {
        eventFlow.collectLatest { event ->
            when (event) {
                is LoginViewModel.UIEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

}

@Composable
@Preview(name = "Modo Claro")
@Preview(name = "Modo Oscuro", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewVistaLogin() {
    AppClinicaUnmsmTheme {
        VistaLogin(navController = rememberNavController())
    }
}