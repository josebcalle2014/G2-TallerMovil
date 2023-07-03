package com.example.appclinicaunmsm.presentacion.vistas.login

import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.appclinicaunmsm.dominio.caso_uso.LoginUsuarioUseCase
import com.example.appclinicaunmsm.presentacion.navegacion.Vista
import com.example.appclinicaunmsm.util.Resultado
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val loginUsuarioUseCase: LoginUsuarioUseCase
) : ViewModel() {
    var state by mutableStateOf(LoginState(isLoading = true))
        private set

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onLoginChanged(dni: String, contrasenia: String) {
        state = state.copy(
            dni = dni,
            contrasenia = contrasenia,
            botonActivo = isValidDni(dni) && isInvalidPassword(contrasenia),
        )
    }

    private fun isValidDni(dni: String): Boolean {
        return dni.length == 8;
    }

    private fun isInvalidPassword(password: String): Boolean {
        return password.length > 3;
    }

    fun onLoginSelected(navController: NavHostController) {
        viewModelScope.launch {
            loginUsuarioUseCase(state.dni).also { resultado ->
                when (resultado) {
                    is Resultado.Cargando -> {
                        state = state.copy(
                            isLoading = true
                        )
                    }

                    is Resultado.Correcto -> {
                        if (resultado.data!!.contrasenia == state.contrasenia) {
                            state = state.copy(
                                login = true,
                                isLoading = false
                            )
                            navController.navigate(Vista.Inicio.route) {
                                popUpTo(Vista.Login.route) {
                                    inclusive = true
                                }
                            }
                        }
                        else {
                            _eventFlow.emit(
                                UIEvent.ShowSnackBar(
                                    "Clave incorrecta para ${state.login}"
                                )
                            )
                        }
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