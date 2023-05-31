package com.example.appclinicaunmsm.presentacion.login.components

import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appclinicaunmsm.presentacion.navigation.Screen

@Composable
fun RegistrarTexto(navController: NavController) {
    Text(
        text = "¿Deseas registrarte?",
        modifier = Modifier.clickable { navController.navigate(Screen.Register.route) },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colors.onBackground
    )
}