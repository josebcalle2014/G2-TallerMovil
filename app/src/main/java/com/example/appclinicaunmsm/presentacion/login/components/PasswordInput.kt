package com.example.appclinicaunmsm.presentacion.login.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PasswordInput(value: String, onValueChange: (String) -> Unit = {}) {
    InputForm(value = value, onValueChange = onValueChange, keyboardType = KeyboardType.Password)
}

@Preview
@Composable
fun PreviewPasswordInput() {
    var password by remember { mutableStateOf("") }
    PasswordInput(value = password, onValueChange = { password = it })
}
