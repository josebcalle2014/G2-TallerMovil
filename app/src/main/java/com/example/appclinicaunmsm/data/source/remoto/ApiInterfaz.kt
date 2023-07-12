package com.example.appclinicaunmsm.data.source.remoto

import com.example.appclinicaunmsm.data.source.remoto.dto.NoticiasDto
import com.example.appclinicaunmsm.data.source.remoto.dto.RegistroDto
import com.example.appclinicaunmsm.data.source.remoto.dto.UsuarioDto
import com.example.appclinicaunmsm.util.Constantes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

//En esta interface se hace llamado a los endpoints
interface ApiInterfaz {
    //APIs de Autenticación
    @GET(Constantes.API_VALIDAR)
    suspend fun validarDatos(@Query("correo_usuario") correo: String): UsuarioDto

    @GET(Constantes.API_LOGIN)
    suspend fun login(@Query("dni") dni: String, @Query("contrasenia") contrasenia: String): List<UsuarioDto>

    @POST(Constantes.API_REGISTRO)
    suspend fun registro(@Body registroDto: RegistroDto): Response<Unit>

    @GET(Constantes.API_NOTICIA)
    suspend fun obtenerNoticias(): NoticiasDto
}