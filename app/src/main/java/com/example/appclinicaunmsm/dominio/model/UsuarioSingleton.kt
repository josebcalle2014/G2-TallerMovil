package com.example.appclinicaunmsm.dominio.model

object UsuarioSingleton {
    private var usuario: Usuario? = null

    fun guardarSesion(usuario: Usuario) {
        this.usuario = usuario
    }

    fun cerrarSesion() {
        this.usuario = null
    }

    fun getUsuario(): Usuario? {
        return usuario
    }

    fun isSesionActiva(): Boolean {
        return usuario != null
    }
}