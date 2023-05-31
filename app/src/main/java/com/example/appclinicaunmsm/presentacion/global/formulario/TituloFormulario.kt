package com.example.appclinicaunmsm.presentacion.global.formulario

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun TituloFormulario(text: String) {
    Text(text = text, fontSize = 30.sp, color = MaterialTheme.colors.onBackground)
}