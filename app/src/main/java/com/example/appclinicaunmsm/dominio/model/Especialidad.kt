package com.example.appclinicaunmsm.dominio.model

data class Especialidad(
    override var title: String,
    override var descripcion: String,
    override var imageUrl: String
) : Item{
}