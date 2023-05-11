package com.example.appclinicaunmsm.presentacion.global.bar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AddBars(navController: NavController, content: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        topBar = { TopBar() },
        content = content,
        bottomBar = { BottomBar(navController) }
    )
}