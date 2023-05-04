package com.example.appclinicaunmsm.presentacion.utils

import androidx.compose.material.BottomAppBar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun BottomBar() {
    BottomAppBar(content = { Text(text = "Barra inferior") })
}