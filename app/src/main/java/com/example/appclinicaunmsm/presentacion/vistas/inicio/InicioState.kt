package com.example.appclinicaunmsm.presentacion.vistas.inicio

import com.example.appclinicaunmsm.dominio.model.Noticia

data class InicioState (
    val noticias: List<Noticia> = emptyList(),
    val isLoading: Boolean = false
)