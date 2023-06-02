package com.example.appclinicaunmsm.presentacion.vistas.registro

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.presentacion.global.formulario.BotonFormulario
import com.example.appclinicaunmsm.presentacion.global.formulario.EmailInput
import com.example.appclinicaunmsm.presentacion.global.formulario.ContrasenaInput
import com.example.appclinicaunmsm.presentacion.global.formulario.TelefonoInput
import com.example.appclinicaunmsm.presentacion.global.formulario.TextoInput
import com.example.appclinicaunmsm.presentacion.global.formulario.TituloFormulario

import com.example.appclinicaunmsm.R
import com.example.appclinicaunmsm.presentacion.navegacion.Vista
import com.example.appclinicaunmsm.presentacion.tema.AppClinicaUnmsmTheme
import com.example.appclinicaunmsm.presentacion.vistas.registro.componentes.LoginTexto

@Composable
fun VistaRegistro(navController: NavHostController) {

    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {

        TituloFormulario(text = stringResource(id = R.string.register_title_form))

        TextoInput(value = name, onValueChange = { name = it }, placeholder = stringResource(id = R.string.name_field_form))
        TextoInput(value = name, onValueChange = { name = it }, placeholder = stringResource(id = R.string.lastname_field_form))
        TextoInput(value = name, onValueChange = { name = it }, placeholder = stringResource(id = R.string.username_field_form))
        EmailInput(value = name, onValueChange = { name = it })
        ContrasenaInput(value = name, onValueChange = { name = it })
        ContrasenaInput(
            value = name, onValueChange = { name = it }, placeholder = stringResource(id = R.string.repeat_password_field_form)
        )
        TelefonoInput(value = name, onValueChange = { name = it })
        BotonFormulario(
            buttonEnabled = true,
            onClick = {
                navController.navigate(Vista.Inicio.route) {
                    popUpTo(Vista.Login.route) {
                        inclusive = true
                    }
                }
            },
            text = stringResource(id = R.string.register_button_form)
        )
        Divider(color = MaterialTheme.colors.onSecondary, thickness = 1.dp)
        LoginTexto(navController = navController)
    }
}

@Composable
@Preview(name = "Modo Claro")
@Preview(name = "Modo Oscuro", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewVistaRegistro() {
    AppClinicaUnmsmTheme {
        VistaRegistro(navController = rememberNavController())
    }
}