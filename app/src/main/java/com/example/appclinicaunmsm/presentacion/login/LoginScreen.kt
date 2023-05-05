package com.example.appclinicaunmsm.presentacion.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appclinicaunmsm.presentacion.login.components.ButtonForm
import com.example.appclinicaunmsm.presentacion.login.components.ForgotPassword
import com.example.appclinicaunmsm.presentacion.login.components.PasswordInput
import com.example.appclinicaunmsm.presentacion.login.components.UserInput

@Composable
fun LoginForm() {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {

        Text(text = "Iniciar sesión", fontSize = 30.sp, color = MaterialTheme.colors.onBackground)

        UserInput(value = username, onValueChange = { username = it })
        PasswordInput(value = password, onValueChange = { password = it })

        val showDialog = remember { mutableStateOf(false) }

        if (showDialog.value) {
            AlertDialog(
                onDismissRequest = { showDialog.value = false },
                title = { Text(text = "Usuario: $username") },
                text = { Text(text = "Contraseña: $password") },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog.value = false
                        }
                    ) {
                        Text(text = "Aceptar")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            showDialog.value = false
                        }
                    ) {
                        Text(text = "Cancelar")
                    }
                }
            )
        }

        ButtonForm(onClick = { showDialog.value = true })

        ForgotPassword()
    }
}

@Preview
@Composable
fun LoginFormPreview() {
    LoginForm()
}