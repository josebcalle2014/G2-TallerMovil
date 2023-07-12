package com.example.appclinicaunmsm.dominio.model

data class Noticia(
    override var title: String,
    override var descripcion: String,
    override var imageUrl: String
) : Item