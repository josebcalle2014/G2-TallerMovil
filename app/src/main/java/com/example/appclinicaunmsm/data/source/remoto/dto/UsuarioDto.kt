package com.example.appclinicaunmsm.data.source.remoto.dto

import com.example.appclinicaunmsm.dominio.model.Usuario

data class UsuarioDto(
    val apellidoMaterno: String,
    val apellidoPaterno: String,
    val contrasenia: String,
    val correo: String,
    val estado: Int,
    val fechaActualizacion: String,
    val fechaCreacion: String,
    val id_usuario: Int,
    val imagen: String,
    val nombre: String
) {
    fun toUsuario(): Usuario {
        return Usuario(
            apellidoMaterno,
            apellidoPaterno,
            contrasenia,
            correo,
            estado,
            fechaActualizacion,
            fechaCreacion,
            id_usuario,
            imagen,
            nombre
        )
    }
}