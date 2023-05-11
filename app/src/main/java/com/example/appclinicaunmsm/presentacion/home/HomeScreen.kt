package com.example.appclinicaunmsm.presentacion.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringArrayResource
import com.example.appclinicaunmsm.presentacion.global.bar.AddBars
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.appclinicaunmsm.R
import com.example.appclinicaunmsm.presentacion.navigation.AppScreens

@Composable
fun HomeScreen(navController: NavController) {
    AddBars (navController = navController) {
        Home(navController = navController)
    }
}

@Composable
fun Home(navController: NavController) {
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
            Button(onClick = { navController.navigate(AppScreens.LOGIN_SCREEN.route) }) {
                Text(text = "Volver al login")
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