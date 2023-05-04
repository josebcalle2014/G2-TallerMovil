package com.example.appclinicaunmsm.presentacion.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun BottomBar() {
    BottomAppBar(content = {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SectionBottomBar("Boton 1")
            SectionBottomBar("Boton 2")
            SectionBottomBar("Boton 3")
            SectionBottomBar("Boton 4")
        }
    })
}

@Composable
fun SectionBottomBar(text: String) {
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            modifier = Modifier.size(20.dp),
            onClick = { /*TODO*/ }
        ) {

        }
        Text(
            fontSize = 12.sp,
            text = text
        )
    }
}