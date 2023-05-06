package com.example.appclinicaunmsm.presentacion.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.appclinicaunmsm.R

@Preview
@Composable
fun Presentation() {

    val features = stringArrayResource(id = R.array.features)
    val featuresDescriptions = stringArrayResource(id = R.array.features_description)

    val presentationItems = arrayOf(
        Pair(features[0], featuresDescriptions[0]),
        Pair(features[1], featuresDescriptions[1]),
        Pair(features[2], featuresDescriptions[2]),
    )

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