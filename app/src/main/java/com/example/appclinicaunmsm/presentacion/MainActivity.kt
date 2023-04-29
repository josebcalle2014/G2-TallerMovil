package com.example.appclinicaunmsm.presentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.appclinicaunmsm.presentacion.login.LoginForm
import com.example.helloworldcompose.ui.theme.AppClinicaUnmsmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppClinicaUnmsmTheme() {
                MainComponent()
            }
        }
    }
}

@Composable
fun MainComponent() {
    LoginForm()
}

@Preview
@Composable
fun MainComponentPreview() {
    AppClinicaUnmsmTheme() {
        MainComponent()
    }
}

@Preview
@Composable
fun MainComponentNightPreview() {
    AppClinicaUnmsmTheme(true) {
        MainComponent()
    }
}
