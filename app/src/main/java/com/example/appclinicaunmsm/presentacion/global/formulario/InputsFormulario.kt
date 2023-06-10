package com.example.appclinicaunmsm.presentacion.global.formulario

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.appclinicaunmsm.R

@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType,
    placeholder: String,
    visualTransformation: VisualTransformation,
) {
    OutlinedTextField(
        value = value, onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = visualTransformation,
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
         placeholder = placeholder,
         visualTransformation = PasswordVisualTransformation()
     )
}

@Composable
fun TextoInput(value: String, onValueChange: (String) -> Unit, placeholder: String) {
    Input(
        value = value,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Text,
        placeholder = placeholder,
        visualTransformation = VisualTransformation.None
    )
}

@Composable
fun EmailInput(value: String, onValueChange: (String) -> Unit, placeholder: String = "Email") {
    Input(
        value = value,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Email,
        placeholder = placeholder,
        visualTransformation = VisualTransformation.None
    )
}

@Composable
fun TelefonoInput(value: String, onValueChange: (String) -> Unit, placeholder: String = "Teléfono") {
    Input(
        value = value,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Phone,
        placeholder = placeholder,
        visualTransformation = VisualTransformation.None
    )
}
