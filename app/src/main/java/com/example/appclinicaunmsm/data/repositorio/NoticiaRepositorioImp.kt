package com.example.appclinicaunmsm.data.repositorio

import com.example.appclinicaunmsm.di.ApiClinicaUNMSM
import com.example.appclinicaunmsm.dominio.model.Noticia
import com.example.appclinicaunmsm.dominio.repositorio.NoticiaRepositorio
import com.example.appclinicaunmsm.util.Resultado
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NoticiaRepositorioImp @Inject constructor(): NoticiaRepositorio {

    override fun getNoticias(): Flow<Resultado<List<Noticia>>> = flow {
        emit(Resultado.Cargando())
        try {
            val respuesta = ApiClinicaUNMSM.obtenerApi().obtenerNoticias().getListNoticia()
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