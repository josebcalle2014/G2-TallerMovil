package com.example.appclinicaunmsm.presentacion.vistas.especialidades

import com.example.appclinicaunmsm.dominio.model.Especialidad

data class EspecialidadesState (
    val especialidades: List<Especialidad> = emptyList(),
    val isLoading: Boolean = false
)
