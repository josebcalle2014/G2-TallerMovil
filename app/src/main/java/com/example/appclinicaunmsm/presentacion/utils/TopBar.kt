package com.example.appclinicaunmsm.presentacion.utils

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun TopBar() {
    TopAppBar(title = { Text(text = "App Clinica UNMSM")})
}
