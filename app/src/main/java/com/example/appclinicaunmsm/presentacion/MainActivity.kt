package com.example.appclinicaunmsm.presentacion

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appclinicaunmsm.dominio.viewModel.LoginViewModel
import com.example.appclinicaunmsm.presentacion.login.LoginForm
import com.example.appclinicaunmsm.presentacion.utils.BottomBar
import com.example.appclinicaunmsm.presentacion.utils.TopBar
import com.example.helloworldcompose.ui.theme.AppClinicaUnmsmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Preview(name = "Full Preview")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MainApp() {
    AppClinicaUnmsmTheme() {
        Scaffold(
            topBar = { TopBar() },
            content = { padding -> Content(modifier = Modifier.padding(padding)) },
            bottomBar = { BottomBar() }
        )
    }
}

@Composable
fun Content(modifier: Modifier) {
    //TODO "Agregar utilidad para el parámetro modifier"
    LoginForm(LoginViewModel())
}