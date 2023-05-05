package com.example.appclinicaunmsm.presentacion.login.components

import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun UserInput(value: String, onValueChange: (String) -> Unit = {} ) {
    InputForm(value = value, onValueChange = onValueChange, keyboardType = KeyboardType.Text)
}

@Preview
@Composable
fun PreviewUserInput() {
    var username by remember { mutableStateOf("") }
    UserInput(value = username, onValueChange = { username = it })
}