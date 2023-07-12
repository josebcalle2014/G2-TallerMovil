package com.example.appclinicaunmsm.dominio.repositorio

import com.example.appclinicaunmsm.dominio.model.Especialidad
import com.example.appclinicaunmsm.util.Resultado
import kotlinx.coroutines.flow.Flow

interface EspecialidadRepositorio {
    fun getEspecialidades(): Flow<Resultado<List<Especialidad>>>
}