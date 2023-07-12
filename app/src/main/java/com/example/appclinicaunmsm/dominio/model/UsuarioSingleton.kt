package com.example.appclinicaunmsm.dominio.model

object UsuarioSingleton {
    private var usuario: Usuario? = null

    fun setUsuario(usuario: Usuario) {
        this.usuario = usuario
    }

    fun cerrarSesion() {
        this.usuario = null
    }

    fun getUsuario(): Usuario? {
        return usuario
    }
}