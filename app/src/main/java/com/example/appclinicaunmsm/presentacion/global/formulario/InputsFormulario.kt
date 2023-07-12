package com.example.appclinicaunmsm.presentacion.global.formulario

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    modifier: Modifier = Modifier.fillMaxWidth(),
    trailingIcon: @Composable() (() -> Unit)? = {},
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        value = value, onValueChange = onValueChange,
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        label = { Text(placeholder) },
        visualTransformation = visualTransformation,
        placeholder = { Text(placeholder) },
        trailingIcon = trailingIcon
    )
}

@Composable
fun ContrasenaInput(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = stringResource(id = R.string.password_field_form)
) {
    val showPassword = remember { mutableStateOf(false) }

    Input(
        value = value,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Password,
        placeholder = placeholder,
        visualTransformation = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { showPassword.value = !showPassword.value }) {
                val icon =
                    if (showPassword.value) Icons.Default.VisibilityOff else Icons.Default.Visibility
                Icon(icon, contentDescription = "Toggle Password Visibility")
            }
        }
    )
}

@Composable
fun TextoInput(value: String, onValueChange: (String) -> Unit, placeholder: String) {
    Input(
        value = value,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Text,
        placeholder = placeholder,
    )
}

@Composable
fun EmailInput(value: String, onValueChange: (String) -> Unit, placeholder: String = "Email") {
    Input(
        value = value,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Email,
        placeholder = placeholder,
    )
}

@Composable
fun TelefonoInput(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "Teléfono"
) {
    Input(
        value = value,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Phone,
        placeholder = placeholder,
    )
}
