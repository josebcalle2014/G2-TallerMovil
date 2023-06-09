package com.example.appclinicaunmsm.dominio.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appclinicaunmsm.di.ApiClinicaUNMSM
import com.example.appclinicaunmsm.dominio.model.noticiaModelos.Noticia
import kotlinx.coroutines.launch

class NoticiaViewModel : ViewModel() {

    var state by mutableStateOf(emptyList<Noticia>())
        private set

    init {
        viewModelScope.launch {
            obtenerNoticias()
        }
    }

    private suspend fun obtenerNoticias() {
        try {
            val noticias = ApiClinicaUNMSM.obtenerApi().obtenerNoticias()
            state = noticias
        } catch (e: Exception) {
            //TODO: Manejar excepcion
        }
    }
}