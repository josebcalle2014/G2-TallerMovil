package com.example.appclinicaunmsm.presentacion.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InputForm(value: String, onValueChange: (String) -> Unit = {} ) {
    OutlinedTextField(value = value, onValueChange = onValueChange, Modifier.fillMaxWidth())
}

@Preview
@Composable
fun PreviewInputForm() {
    var username by remember { mutableStateOf("") }
    InputForm(value = username, onValueChange = { username = it })
}