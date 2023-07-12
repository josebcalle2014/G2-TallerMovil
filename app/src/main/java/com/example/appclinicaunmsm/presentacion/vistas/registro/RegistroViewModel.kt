package com.example.appclinicaunmsm.presentacion.vistas.registro

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.appclinicaunmsm.data.source.remoto.dto.RegistroDto
import com.example.appclinicaunmsm.dominio.caso_uso.RegistroUsuarioUseCase
import com.example.appclinicaunmsm.presentacion.navegacion.Vista
import com.example.appclinicaunmsm.util.Resultado
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistroViewModel @Inject constructor(
    val registroUsuarioUseCase: RegistroUsuarioUseCase
) : ViewModel() {
    var state by mutableStateOf(RegistroState())
        private set

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onValueChange(registroDto: RegistroDto) {
        state = state.copy(
            registroDto = registroDto,
            botonActivo = isValid(registroDto)
        )
    }

    fun isValid(registroDto: RegistroDto): Boolean {
        return registroDto.isValido()
    }

    fun onRegistroSelected(navController: NavHostController) {
        viewModelScope.launch {
            registroUsuarioUseCase(state.registroDto).let { resultado ->
                when (resultado) {
                    is Resultado.Cargando -> {
                        state = state.copy(
                            isLoading = true
                        )
                    }

                    is Resultado.Correcto -> {
                        state = state.copy(
                            isRegister = true,
                            isLoading = false
                        )
                        navController.navigate(Vista.Login.route) {
                            popUpTo(Vista.Login.route) {
                                inclusive = true
                            }
                        }
                        _eventFlow.emit(
                            UIEvent.ShowSnackBar(
                                "Registro exitoso"
                            )
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
                }
            }
        }
    }

    sealed class UIEvent {
        data class ShowSnackBar(val message: String) : UIEvent()
    }
}