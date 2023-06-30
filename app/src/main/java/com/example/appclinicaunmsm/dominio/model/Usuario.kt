package com.example.appclinicaunmsm.dominio.model

class Usuario constructor(
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
}