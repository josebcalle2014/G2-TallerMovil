package com.example.appclinicaunmsm.presentacion.global.formulario

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BotonFormulario(buttonEnabled: Boolean, onClick: () -> Unit, text: String) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        enabled = buttonEnabled,
    ) {
        Icon(
            imageVector = Icons.Filled.AccountBox,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text)
    }
}

@Composable
fun BotonPrimario(
    buttonEnabled: Boolean,
    onClick: () -> Unit,
    text: String
) {
    TextButton(
        onClick = onClick,
        enabled = buttonEnabled,
        colors = ButtonDefaults.textButtonColors(
            contentColor = MaterialTheme.colors.onPrimary,
            backgroundColor = MaterialTheme.colors.primary
        ),
    ) {
        Text(text)
    }
}
@Composable
fun BotonSecundario(
    buttonEnabled: Boolean,
    onClick: () -> Unit,
    text: String
) {
    TextButton(
        onClick = onClick,
        enabled = buttonEnabled,
        colors = ButtonDefaults.textButtonColors(
            contentColor = MaterialTheme.colors.onSecondary,
            backgroundColor = MaterialTheme.colors.secondary
        ),
    ) {
        Text(text)
    }
}