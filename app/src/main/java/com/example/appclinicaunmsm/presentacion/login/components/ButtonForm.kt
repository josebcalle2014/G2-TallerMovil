package com.example.appclinicaunmsm.presentacion.login.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ButtonForm(loginEnabled: Boolean, onClick: () -> Unit) {
    Button(onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        enabled = loginEnabled) {
        Icon(
            Icons.Filled.AccountBox,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Ingresar")
    }
}