package com.example.appclinicaunmsm.presentacion.global.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appclinicaunmsm.R
import com.example.appclinicaunmsm.dominio.model.servicioModelos.Servicio
import com.example.appclinicaunmsm.adapter.Item
import com.example.appclinicaunmsm.presentacion.global.formulario.BotonPrimario
import com.example.appclinicaunmsm.presentacion.global.formulario.BotonSecundario

@Composable
fun Seccion(title: String, itemsList: List<Item>) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(text = title, style = MaterialTheme.typography.h5)
        Divider(color = MaterialTheme.colors.onBackground, thickness = 1.dp)
        CarruselVertical(itemsList)
    }
}

@Composable
fun CarruselVertical(itemsList: List<Item>) {
    LazyColumn(modifier = Modifier.padding(bottom = 40.dp)) {
        items(itemsList) { item ->
            ComponenteItem(item = item)
        }
    }
}

@Composable
fun ComponenteItem(item: Item) {
    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "Titulo: ${item.titulo}") },
            text = { Text(text = "Descripcion: ${item.descripcion}") },
            confirmButton = {
                BotonPrimario(
                    onClick = {
                        showDialog.value = false
                    },
                    buttonEnabled = true,
                    text = "Aceptar"
                )
            },
            dismissButton = {
                BotonSecundario(
                    onClick = {
                        showDialog.value = false
                    },
                    buttonEnabled = true,
                    text = "Cancelar"
                )
            }
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = item.titulo,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.weight(1f)
                )
                BotonPrimario(buttonEnabled = true, onClick = { showDialog.value = true }, text = "Ver más")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = item.descripcion, style = MaterialTheme.typography.body1)
            }
        }
    }
}

@Preview
@Composable
fun PreviewSeccion() {
    val title = "Servicios"
    val items = listOf(
        Servicio("Servicio 1", "Descripcion 1", "img1"),
        Servicio("Servicio 2", "Descripcion 2", "img2"),
        Servicio("Servicio 3", "Descripcion 3", "img3"),
    )
    Seccion(title, items)
}