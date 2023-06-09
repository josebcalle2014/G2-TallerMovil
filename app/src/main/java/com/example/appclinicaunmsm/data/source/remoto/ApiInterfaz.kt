package com.example.appclinicaunmsm.data.source.remoto

import com.example.appclinicaunmsm.data.source.remoto.dto.LoginDto
import com.example.appclinicaunmsm.dominio.model.LoginModelos.LoginInicioSesion
import com.example.appclinicaunmsm.dominio.model.noticiaModelos.Noticia
import com.example.appclinicaunmsm.util.Constantes
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

//En esta interface se hace llamado a los endpoints
interface ApiInterfaz {
    //APIs de Autenticación
    @POST(Constantes.API_LOGIN)
    suspend fun validarDatos(@Body loginInicioSesion : LoginInicioSesion
    ): LoginDto

    @GET(Constantes.API_NOTICIAS)
    suspend fun obtenerNoticias() : List<Noticia>
}