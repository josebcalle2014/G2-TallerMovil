package com.example.appclinicaunmsm.data.source.remoto

import com.example.appclinicaunmsm.data.source.remoto.dto.NoticiasDto
import com.example.appclinicaunmsm.data.source.remoto.dto.UsuarioDto
import com.example.appclinicaunmsm.util.Constantes
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

//En esta interface se hace llamado a los endpoints
interface ApiInterfaz {
    //APIs de Autenticación
    @GET(Constantes.API_LOGIN)
    suspend fun validarDatos(@Query("correo_usuario") correo: String): UsuarioDto

    @POST(Constantes.API_REGISTRO)
    suspend fun registro(@Body usuarioDto: UsuarioDto): UsuarioDto

    @GET(Constantes.API_NOTICIA)
    suspend fun obtenerNoticias(): NoticiasDto
}