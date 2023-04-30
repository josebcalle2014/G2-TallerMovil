package com.example.appclinicaunmsm.dominio.model.LoginModelos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginInicioSesion(
    val sDocUsu:String,
    val sClaUsu:String,
    val sVerApp:String,
    val sVerAnd:String,
    val sModCel:String,
):Parcelable