package com.example.appclinicaunmsm.data.source.remoto.dto

import com.example.appclinicaunmsm.dominio.model.Usuario

data class UsuarioDto(
    val id_usuario: Int,
    val nombre: String,
    val apellidoPaterno: String,
    val apellidoMaterno: String,
    val correo: String,
    val imagen: String,
    val telefono: String,
    val tipo_usuario: Int,
    val direccion: String,
    val fecha_nacimiento: String,
    val genero: String,
    val tipo_sangre: String,
) {
    fun toUsuario(): Usuario {
        return Usuario(
            apellidoMaterno,
            apellidoPaterno,
            correo,
            id_usuario,
            imagen,
            nombre,
            telefono,
            direccion,
            genero,
            tipo_sangre
        )
    }
}