package com.example.appclinicaunmsm.presentacion.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

val presentationItems = arrayOf(
    Pair("Agenda tus citas", "Ahorra tu tiempo"),
    Pair("Característica 2", "Subtitulo 2"),
    Pair("Característica 3", "Subtitulo 3"),
)

@Preview
@Composable
fun Presentation() {
    var actualIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row() {
            // TODO: Agregar imagen 1
            // TODO: Agregar imagen 2
        }
        Row() {
            Text(presentationItems[actualIndex].first)
            Text(presentationItems[actualIndex].second)
        }
        Row() {
            Button(onClick = { /*TODO*/ }) {
                
            }
            Column() {
                // TODO: Agregar icono de bola 1
                // TODO: Agregar icono de bola 2
                // TODO: Agregar icono de bola 3
                Text("Omitir")
            }
        }
    }

}