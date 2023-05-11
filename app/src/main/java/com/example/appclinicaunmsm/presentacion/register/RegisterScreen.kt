package com.example.appclinicaunmsm.presentacion.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appclinicaunmsm.presentacion.global.form.ButtonForm
import com.example.appclinicaunmsm.presentacion.global.form.EmailInput
import com.example.appclinicaunmsm.presentacion.global.form.PasswordInput
import com.example.appclinicaunmsm.presentacion.global.form.PhoneInput
import com.example.appclinicaunmsm.presentacion.global.form.TextInput
import com.example.appclinicaunmsm.presentacion.global.form.TitleForm

@Composable
fun RegisterScreen() {

    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        TitleForm(text = "Registrarse")
        TextInput(value = name, onValueChange = { name = it }, placeholder = "Nombres")
        TextInput(value = name, onValueChange = { name = it }, placeholder = "Apellidos")
        TextInput(value = name, onValueChange = { name = it }, placeholder = "Nombre de usuario")
        EmailInput(value = name, onValueChange = { name = it })
        PasswordInput(value = name, onValueChange = { name = it })
        PasswordInput(
            value = name,
            onValueChange = { name = it },
            placeholder = "Repita su contraseña"
        )
        PhoneInput(value = name, onValueChange = { name = it })
        ButtonForm(buttonEnabled = true, onClick = {}, text = "Registrarse")
    }
}

@Preview
@Composable
fun PreviewRegistreScreen() {
    RegisterScreen()
}