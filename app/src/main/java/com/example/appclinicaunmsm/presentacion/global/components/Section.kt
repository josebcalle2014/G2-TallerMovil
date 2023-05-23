package com.example.appclinicaunmsm.presentacion.global.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appclinicaunmsm.R
import com.example.appclinicaunmsm.dominio.model.ClinicServices
import com.example.appclinicaunmsm.dominio.model.Item


@Composable
fun Section(title: String, itemsList: List<Item>) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(text = title, style = MaterialTheme.typography.h5)
        Divider(color = MaterialTheme.colors.onBackground, thickness = 1.dp)
        VerticalCarousel(itemsList)
    }
}

@Composable
fun VerticalCarousel(itemsList: List<Item>) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(itemsList) { item ->
            ItemComponent(item = item)
        }
    }
}

@Composable
fun ItemComponent(item: Item) {
    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "Titulo: ${item.title}") },
            text = { Text(text = "Descripcion: ${item.description}") },
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

    Column(
        modifier = Modifier
            .width(360.dp)
            .height(200.dp)
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = item.title, style = MaterialTheme.typography.subtitle1)
            Text(
                text = "ver más",
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onSecondary,
                modifier = Modifier.clickable { showDialog.value = true}
            )
        }
        Row(
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = item.imageUrl,
            )
            Text(
                text = item.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview
@Composable
fun SectionPreview() {
    val title = "Servicios"
    val items = listOf(
        ClinicServices("Servicio 1", "Descripcion 1", "img1"),
        ClinicServices("Servicio 2", "Descripcion 2", "img2"),
        ClinicServices("Servicio 3", "Descripcion 3", "img3"),
    )
    Section(title, items)
}