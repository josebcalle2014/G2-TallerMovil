package com.example.appclinicaunmsm.presentacion.login

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
import com.example.appclinicaunmsm.presentacion.global.form.ButtonForm
import com.example.appclinicaunmsm.presentacion.global.form.PasswordInput
import com.example.appclinicaunmsm.presentacion.global.form.TextInput
import com.example.appclinicaunmsm.presentacion.global.form.TitleForm
import com.example.appclinicaunmsm.presentacion.login.components.OlvidoContrasenaTexto
import com.example.appclinicaunmsm.presentacion.login.components.RegistrarTexto
import com.example.appclinicaunmsm.presentacion.navigation.Vista

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

        TitleForm(text = stringResource(id = R.string.login_title_form))

        TextInput(
            value = username,
            onValueChange = { viewModel.onLoginChanged(it, password) },
            placeholder = stringResource(id = R.string.username_field_form)
        )
        PasswordInput(value = password, onValueChange = { viewModel.onLoginChanged(username, it) })

        ButtonForm(
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
@Preview
fun PreviewVistaLogin() {
    VistaLogin(navController = rememberNavController(), viewModel = LoginViewModel())
}