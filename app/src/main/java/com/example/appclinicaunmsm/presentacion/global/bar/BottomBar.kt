package com.example.appclinicaunmsm.presentacion.global.bar

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.appclinicaunmsm.presentacion.navigation.Screen

@Composable
fun BottomBar(
    currentScreen: Screen,
    onScreenSelected: (Screen) -> Unit
) {
    Column {
        BottomNavigation {
            BottomNavigationItem(
                selected = currentScreen == Screen.Home,
                onClick = { onScreenSelected(Screen.Home) },
                icon = {
                    Icon(
                        imageVector = Screen.Home.icon,
                        contentDescription = Screen.Home.route
                    )
                },
                label = { Text(text = Screen.Home.route) }
            )
            BottomNavigationItem(
                selected = currentScreen == Screen.Appointment,
                onClick = { onScreenSelected(Screen.Appointment) },
                icon = {
                    Icon(
                        imageVector = Screen.Appointment.icon,
                        contentDescription = Screen.Appointment.route
                    )
                },
                label = { Text(text = Screen.Appointment.route) }
            )
            BottomNavigationItem(
                selected = currentScreen == Screen.History,
                onClick = { onScreenSelected(Screen.History) },
                icon = {
                    Icon(
                        imageVector = Screen.History.icon,
                        contentDescription = Screen.History.route
                    )
                },
                label = { Text(text = Screen.History.route) }
            )
            BottomNavigationItem(
                selected = currentScreen == Screen.Settings,
                onClick = { onScreenSelected(Screen.Settings) },
                icon = {
                    Icon(
                        imageVector = Screen.Settings.icon,
                        contentDescription = Screen.Settings.route
                    )
                },
                label = { Text(text = Screen.Settings.route) }
            )
        }
    }
}

@Preview
@Composable
fun PreviewBottomBar() {
    BottomBar(currentScreen = Screen.Home, onScreenSelected = {})
}