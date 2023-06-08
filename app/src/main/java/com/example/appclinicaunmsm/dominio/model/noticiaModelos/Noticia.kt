package com.example.appclinicaunmsm.dominio.model.noticiaModelos

import com.example.appclinicaunmsm.adapter.Item

data class Noticia(
    override var titulo: String,
    override var descripcion: String,
    override var urlImagen: String
) : Item