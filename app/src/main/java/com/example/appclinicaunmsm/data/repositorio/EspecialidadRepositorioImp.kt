package com.example.appclinicaunmsm.data.repositorio

import com.example.appclinicaunmsm.di.ApiClinicaUNMSM
import com.example.appclinicaunmsm.dominio.model.Especialidad
import com.example.appclinicaunmsm.dominio.repositorio.EspecialidadRepositorio
import com.example.appclinicaunmsm.util.Resultado
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class EspecialidadRepositorioImp @Inject constructor() : EspecialidadRepositorio{
    override fun getEspecialidades(): Flow<Resultado<List<Especialidad>>> = flow {
        emit(Resultado.Cargando())
        try {
            val respuesta = ApiClinicaUNMSM.obtenerApi().obtenerEspecialidades().getListEspecialidad()
            emit(Resultado.Correcto(respuesta))
        } catch (e: HttpException) {
            emit(Resultado.Error(
                message = "Ocurrió un error",
                data = null
            ))
        } catch (e: IOException) {
            emit(Resultado.Error(
                message = "No tienes conexión a internet",
                data = null
            ))
        }
    }
}