package com.example.appclinicaunmsm.dominio.model

data class Usuario (
    val apellidoMaterno: String,
    val apellidoPaterno: String,
    val correo: String,
    val idUsuario: Int,
    val imagen: String,
    val nombre: String,
    val telefono: String,
    val direccion: String,
    val genero: String,
    val tipoSangre: String
)