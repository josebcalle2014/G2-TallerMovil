package com.example.appclinicaunmsm.presentacion.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val navBarItems = arrayOf(
    Pair("Inicio", Icons.Outlined.Home),
    Pair("Citas", Icons.Outlined.AccountCircle),
    Pair("Historial", Icons.Outlined.Info),
    Pair("Configuración", Icons.Outlined.Settings),
)

@Composable
@Preview
fun BottomBar() {
    BottomAppBar(content = {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            for (item in navBarItems) {
                SectionBottomBar(item.first, item.second)
            }
        }
    })
}

@Composable
fun SectionBottomBar(text: String, imageVector: ImageVector) {
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        IconButton(
            modifier = Modifier.size(20.dp),
            onClick = { /*TODO*/ }
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = "dummy",
            )
        }
        Text(
            fontSize = 12.sp,
            text = text
        )
    }
}