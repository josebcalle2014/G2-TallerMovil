package com.example.appclinicaunmsm.data.source.remoto.dto

data class RegistroDto(
    val apellidoMaterno: String = "",
    val apellidoPaterno: String = "",
    val contrasenia: String = "",
    val contrasenia2: String = "",
    val fecha_nacimiento: String = "2023-07-08T16:45:10.983Z",
    val correo: String = "",
    val direccion: String = "",
    val dni: String = "",
    val genero: String = "",
    val imagen: String = "null",
    val nombre: String = "",
    val telefono: String = "null",
    val tipo_sangre: String = "",
    val estado: Int = 1
) {
    fun isValido(): Boolean {
        return apellidoMaterno != "" &&
                apellidoPaterno != "" &&
                contrasenia != "" &&
                contrasenia == contrasenia2 &&
                correo != "" &&
                direccion != "" &&
                dni != "" &&
                genero != "" &&
                genero.length == 1 &&
                imagen != "" &&
                nombre != "" &&
                tipo_sangre != ""
    }
}