package com.example.appclinicaunmsm.presentacion.vistas.registro.componentes

import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appclinicaunmsm.presentacion.navegacion.Vista

@Composable
fun LoginTexto(navController: NavController) {
    Text(
        text = "¿Ya tienes un usuario? iniciar sesión",
        modifier = Modifier.clickable { navController.navigate(Vista.Login.route) },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colors.onBackground
    )
}