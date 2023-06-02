package com.example.appclinicaunmsm.presentacion.global.barras

import android.content.res.Configuration
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.R
import com.example.appclinicaunmsm.presentacion.tema.AppClinicaUnmsmTheme

@Composable
fun BarraSuperior(navController: NavController) {
    TopAppBar(title = { Text(text = stringResource(R.string.app_name)) },
        navigationIcon = if (navController.previousBackStackEntry != null) {
            {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, contentDescription = "ArrowBack"
                    )
                }
            }
        } else {
            null
        })
}

@Composable
@Preview(name = "Modo Claro")
@Preview(name = "Modo Oscuro", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewBarraSuperior() {
    AppClinicaUnmsmTheme {
        BarraSuperior(navController = rememberNavController())
    }
}