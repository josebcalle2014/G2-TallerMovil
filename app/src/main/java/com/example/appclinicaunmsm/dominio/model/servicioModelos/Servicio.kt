package com.example.appclinicaunmsm.dominio.model.servicioModelos

import com.example.appclinicaunmsm.adapter.Item

data class Servicio(
    override var id: String,
    override var titulo: String,
    override var descripcion: String,
    override var urlImagen: String
) : Item {
}