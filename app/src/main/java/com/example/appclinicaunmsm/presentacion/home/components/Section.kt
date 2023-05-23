package com.example.appclinicaunmsm.presentacion.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appclinicaunmsm.R
import com.example.appclinicaunmsm.dominio.model.Item
import com.example.appclinicaunmsm.dominio.model.News


@Composable
fun Section(title: String, itemsList: List<Item>) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(text = title)
        Divider(color = MaterialTheme.colors.onBackground, thickness = 1.dp)
        CarouselItems(itemsList)
    }
}

@Composable
fun CarouselItems(itemsList: List<Item>) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(itemsList) {
                item ->
            ShowItem(item = item)
        }
    }
}

@Composable
fun ShowItem(item: Item) {
    Column(modifier = Modifier
        .width(360.dp)
        .padding(20.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = item.title)
            Text(text = "ver más")
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
                textAlign = TextAlign.Center) // Agregar el modificador fillMaxWidth()
        }
    }
}

@Preview
@Composable
fun SectionPreview() {
    val title = "Noticias"
    val items = listOf<News>(
        News("titulo 1", "descripcion", "xd"),
        News("Titulo 2", "descripcion 2", "xd2"),
        News("Titulo 3", "descripcion 3", "xd3")
    )
    Section(title, items)
}