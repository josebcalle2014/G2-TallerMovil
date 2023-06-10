package com.example.appclinicaunmsm.dominio.model.historialModelos

import com.example.appclinicaunmsm.adapter.Item

class Historial(
    override var titulo: String,
    override var descripcion: String,
    override var urlImagen: String
) : Item {
}