package com.example.appclinicaunmsm.dominio.caso_uso

import com.example.appclinicaunmsm.data.repositorio.EspecialidadRepositorioImp
import com.example.appclinicaunmsm.dominio.model.Especialidad
import com.example.appclinicaunmsm.util.Resultado
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEspecialidadesUseCase @Inject constructor(
    val repositorio: EspecialidadRepositorioImp
) {
    operator fun invoke(): Flow<Resultado<List<Especialidad>>> {
        return repositorio.getEspecialidades()
    }
}