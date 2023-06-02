package com.example.appclinicaunmsm.presentacion.vistas.login

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.R
import com.example.appclinicaunmsm.dominio.viewModel.LoginViewModel
import com.example.appclinicaunmsm.presentacion.global.formulario.BotonFormulario
import com.example.appclinicaunmsm.presentacion.global.formulario.ContrasenaInput
import com.example.appclinicaunmsm.presentacion.global.formulario.TextoInput
import com.example.appclinicaunmsm.presentacion.global.formulario.TituloFormulario
import com.example.appclinicaunmsm.presentacion.vistas.login.componentes.OlvidoContrasenaTexto
import com.example.appclinicaunmsm.presentacion.vistas.login.componentes.RegistrarTexto
import com.example.appclinicaunmsm.presentacion.navegacion.Vista
import com.example.appclinicaunmsm.presentacion.tema.AppClinicaUnmsmTheme

@Composable
fun VistaLogin(navController: NavHostController, viewModel: LoginViewModel) {

    val username: String by viewModel.username.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnabled: Boolean by viewModel.loginEnabled.observeAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {

        TituloFormulario(text = stringResource(id = R.string.login_title_form))

        TextoInput(
            value = username,
            onValueChange = { viewModel.onLoginChanged(it, password) },
            placeholder = stringResource(id = R.string.username_field_form)
        )
        ContrasenaInput(value = password, onValueChange = { viewModel.onLoginChanged(username, it) })

        BotonFormulario(
            buttonEnabled = loginEnabled,
            onClick = {
                viewModel.onLoginSelected()
                navController.navigate(Vista.Inicio.route) {
                    popUpTo(Vista.Login.route) {
                        inclusive = true
                    }
                }
            },
            text = stringResource(id = R.string.login_button_form)
        )

        OlvidoContrasenaTexto(navController = navController)
        Divider(color = MaterialTheme.colors.onSecondary, thickness = 1.dp)
        RegistrarTexto(navController = navController)
    }
}

@Composable
@Preview(name = "Modo Claro")
@Preview(name = "Modo Oscuro", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewVistaLogin() {
    AppClinicaUnmsmTheme {
        VistaLogin(navController = rememberNavController(), viewModel = LoginViewModel())
    }
}