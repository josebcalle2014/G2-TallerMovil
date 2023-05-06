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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appclinicaunmsm.presentacion.global.form.ButtonForm
import com.example.appclinicaunmsm.presentacion.global.form.EmailInput
import com.example.appclinicaunmsm.presentacion.global.form.PasswordInput
import com.example.appclinicaunmsm.presentacion.global.form.PhoneInput
import com.example.appclinicaunmsm.presentacion.global.form.TextInput
import com.example.appclinicaunmsm.presentacion.global.form.TitleForm

import com.example.appclinicaunmsm.R

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

        TitleForm(text = stringResource(id = R.string.register_title_form))

        TextInput(value = name, onValueChange = { name = it }, placeholder = stringResource(id = R.string.name_field_form))
        TextInput(value = name, onValueChange = { name = it }, placeholder = stringResource(id = R.string.lastname_field_form))
        TextInput(value = name, onValueChange = { name = it }, placeholder = stringResource(id = R.string.username_field_form))
        EmailInput(value = name, onValueChange = { name = it })
        PasswordInput(value = name, onValueChange = { name = it })
        PasswordInput(
            value = name, onValueChange = { name = it }, placeholder = stringResource(id = R.string.repeat_password_field_form)
        )
        PhoneInput(value = name, onValueChange = { name = it })
        ButtonForm(
            buttonEnabled = true,
            onClick = {},
            text = stringResource(id = R.string.register_button_form)
        )
    }
}

@Preview
@Composable
fun PreviewRegistreScreen() {
    RegisterScreen()
}