package com.example.appclinicaunmsm.presentacion.global.bar

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.appclinicaunmsm.R

@Composable
fun TopBar(navController: NavController) {
    TopAppBar(title = { Text(text = stringResource(R.string.app_name)) },
        navigationIcon = if (navController.previousBackStackEntry != null) {
            {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, contentDescription = "ArrowBack"
                    )
                }
            }
        } else { null }
    )

}
