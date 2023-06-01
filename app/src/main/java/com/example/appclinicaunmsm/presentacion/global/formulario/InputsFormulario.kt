package com.example.appclinicaunmsm.presentacion.global.formulario

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.appclinicaunmsm.R

@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType,
    placeholder: String
) {
    OutlinedTextField(
        value = value, onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        placeholder = { Text(placeholder) }
    )
}

@Composable
fun ContrasenaInput(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = stringResource(id = R.string.password_field_form)
) {
     Input(
         value = value,
         onValueChange = onValueChange,
         keyboardType = KeyboardType.Password,
         placeholder = placeholder
     )
}

@Composable
fun TextoInput(value: String, onValueChange: (String) -> Unit, placeholder: String) {
    Input(
        value = value,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Text,
        placeholder = placeholder
    )
}

@Composable
fun EmailInput(value: String, onValueChange: (String) -> Unit, placeholder: String = "Email") {
    Input(
        value = value,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Email,
        placeholder = placeholder
    )
}

@Composable
fun TelefonoInput(value: String, onValueChange: (String) -> Unit, placeholder: String = "Teléfono") {
    Input(
        value = value,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Phone,
        placeholder = placeholder
    )
}
