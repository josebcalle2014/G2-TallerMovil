package com.example.appclinicaunmsm.data.source.remoto.dto

import com.example.appclinicaunmsm.dominio.model.Especialidad

class EspecialidadesDto : ArrayList<EspecialidadDto>() {
    fun getListEspecialidad() : List<Especialidad> {
        val lista = mutableListOf<Especialidad>()
        for (dto in this) {
            if (dto.estado == 1) {
                val especialidad = dto.toEspecialidad()
                lista.add(especialidad)
            }
        }
        return lista
    }
}