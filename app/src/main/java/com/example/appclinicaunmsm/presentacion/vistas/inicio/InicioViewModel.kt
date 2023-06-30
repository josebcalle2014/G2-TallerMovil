package com.example.appclinicaunmsm.presentacion.vistas.inicio

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appclinicaunmsm.dominio.caso_uso.GetNoticiasUseCase
import com.example.appclinicaunmsm.util.Resultado
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InicioViewModel @Inject constructor(
    private val getNoticiasUseCase: GetNoticiasUseCase
): ViewModel() {

    var state by mutableStateOf(InicioState(isLoading = true))
        private set

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        getNoticias()
    }

    fun getNoticias() {
        viewModelScope.launch {
            getNoticiasUseCase().onEach { resultado ->
                when (resultado) {
                    is Resultado.Correcto -> {
                        state = state.copy(
                            noticias = resultado.data ?: emptyList(),
                            isLoading = false
                        )
                    }

                    is Resultado.Error -> {
                        state = state.copy(
                            isLoading = false
                        )
                        _eventFlow.emit(
                            UIEvent.ShowSnackBar(
                                resultado.message ?: "Error desconocido"
                            )
                        )
                    }

                    is Resultado.Cargando -> {
                        state = state.copy(
                            isLoading = true
                        )
                    }
                }
            }
            //.launchIn(this)
        }
    }


    sealed class UIEvent {
        data class ShowSnackBar(val message: String): UIEvent()
    }
}