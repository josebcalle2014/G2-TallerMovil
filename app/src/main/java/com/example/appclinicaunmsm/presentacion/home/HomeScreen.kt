package com.example.appclinicaunmsm.presentacion.home

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringArrayResource
import com.example.appclinicaunmsm.presentacion.global.bar.BarsWrapper
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.R
import com.example.appclinicaunmsm.dominio.model.ClinicServices
import com.example.appclinicaunmsm.dominio.model.News
import com.example.appclinicaunmsm.presentacion.home.components.Section
import com.example.appclinicaunmsm.presentacion.navigation.AppScreens

@Composable
fun HomeScreen(navController: NavController) {
    BarsWrapper (navController = navController) {
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

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        item {
            TitleScreen(text = "Noticias")
            val newsTitle = "Noticias"
            val newsItems = listOf<News>(
                News("Noticia 1", "Descripcion 1", "img1"),
                News("Noticia 2", "Descripcion 2", "img2"),
                News("Noticia 3", "Descripcion 3", "img3")
            )
            Section(newsTitle, newsItems)
            val serviceTitle  = "Servicios"
            val serviceItems = listOf<ClinicServices>(
                ClinicServices("Servicio 1", "Descripcion 1", "img1"),
                ClinicServices("Servicio 2", "Descripcion 2", "img2"),
                ClinicServices("Servicio 3", "Descripcion 3", "img3"),
            )
            Section(serviceTitle, serviceItems)
            Button(onClick = { navController.navigate(AppScreens.LOGIN_SCREEN.route) }) {
                Text(text = "volver al login")
            }
        }
    }
 }

@Composable
fun TitleScreen(text: String) {
    Text(
        text = text,
        modifier = Modifier.fillMaxWidth(),
        fontSize = 20.sp
    )
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}