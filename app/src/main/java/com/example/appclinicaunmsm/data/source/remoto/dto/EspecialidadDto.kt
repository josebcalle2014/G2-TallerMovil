package com.example.appclinicaunmsm.data.source.remoto.dto

import com.example.appclinicaunmsm.dominio.model.Especialidad

data class EspecialidadDto(
    val descripcion: String,
    val estado: Int,
    val id_especialidad: Int,
    val imagen: String,
    val nombre_especialidad: String
) {
    fun toEspecialidad(): Especialidad {
        return Especialidad(
            title = nombre_especialidad,
            descripcion = descripcion,
            imageUrl = imagen
        )
    }
}