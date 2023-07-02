package com.example.appclinicaunmsm.presentacion.vistas.registro

import com.example.appclinicaunmsm.data.source.remoto.dto.RegistroDto

data class RegistroState(
    val registroDto: RegistroDto = RegistroDto(),
    val botonActivo: Boolean = false,
    val isLoading: Boolean = false,
    var isRegister: Boolean = false
)