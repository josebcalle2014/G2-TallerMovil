package com.example.appclinicaunmsm.data.source.remoto.dto

data class RegistroDto(
    val nombre: String = "",
    val apellidoPaterno: String = "",
    val apellidoMaterno: String = "",
    val correo: String = "",
    val contrasenia: String = "",
    val contrasenia2: String = "",
    val dni: String = "",
    val imagen: String = "null",
    val telefono: String = "null"
) {
    fun isValido(): Boolean {
        return nombre != "" && apellidoPaterno != "" && apellidoMaterno != "" && correo != "" && dni != ""
                contrasenia != "" && contrasenia2 != ""
    }
}