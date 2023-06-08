package com.example.appclinicaunmsm.dominio.model.citaModelos

import com.example.appclinicaunmsm.adapter.Item

data class Cita(
    override var titulo: String,
    override var descripcion: String,
    override var urlImagen: String
) : Item {
}