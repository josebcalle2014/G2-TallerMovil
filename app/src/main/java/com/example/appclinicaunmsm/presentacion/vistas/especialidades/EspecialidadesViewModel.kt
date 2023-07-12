package com.example.appclinicaunmsm.presentacion.vistas.especialidades

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appclinicaunmsm.dominio.caso_uso.GetEspecialidadesUseCase
import com.example.appclinicaunmsm.util.Resultado
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EspecialidadesViewModel @Inject constructor(
    val getEspecialidadesUseCase: GetEspecialidadesUseCase
) : ViewModel() {

    var state by mutableStateOf(EspecialidadesState())
        private set

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        getEspecialidades()
    }

    fun getEspecialidades() {
        viewModelScope.launch {
            getEspecialidadesUseCase().onEach { resultado ->
                when (resultado) {
                    is Resultado.Correcto -> {
                        state = state.copy(
                            especialidades = resultado.data ?: emptyList(),
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
            }.launchIn(this)
        }
    }

    sealed class UIEvent {
        data class ShowSnackBar(val message: String): UIEvent()
    }
}