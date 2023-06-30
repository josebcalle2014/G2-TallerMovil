package com.example.appclinicaunmsm.util

sealed class Resultado<T>(val data: T? = null, val message: String? = null) {
    class Cargando<T>(data: T? = null): Resultado<T>(data)
    class Correcto<T>(data: T?): Resultado<T>(data)
    class Error<T>(message: String, data: T? = null): Resultado<T>(data, message)
}