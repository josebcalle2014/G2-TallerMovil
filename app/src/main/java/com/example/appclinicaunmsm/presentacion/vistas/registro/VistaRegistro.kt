package com.example.appclinicaunmsm.presentacion.vistas.registro

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appclinicaunmsm.R
import com.example.appclinicaunmsm.presentacion.global.formulario.BotonFormulario
import com.example.appclinicaunmsm.presentacion.global.formulario.ContrasenaInput
import com.example.appclinicaunmsm.presentacion.global.formulario.EmailInput
import com.example.appclinicaunmsm.presentacion.global.formulario.TextoInput
import com.example.appclinicaunmsm.presentacion.global.formulario.TituloFormulario
import com.example.appclinicaunmsm.presentacion.tema.AppClinicaUnmsmTheme
import com.example.appclinicaunmsm.presentacion.vistas.registro.componentes.LoginTexto
import kotlinx.coroutines.flow.collectLatest

@Composable
fun VistaRegistro(
    navController: NavHostController,
    viewModel: RegistroViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val eventFlow = viewModel.eventFlow
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        eventFlow.collectLatest { event ->
            when (event) {
                is RegistroViewModel.UIEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(paddingValues)
                .padding(20.dp),
            contentPadding = PaddingValues(all = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
        ) {

            item {
                TituloFormulario(text = stringResource(id = R.string.register_title_form))
            }

            item {
                TextoInput(
                    value = state.registroDto.nombre,
                    onValueChange = {
                        viewModel.onValueChange(
                            state.registroDto.copy(
                                nombre = it
                            )
                        )
                    },
                    placeholder = stringResource(id = R.string.name_field_form)
                )
                TextoInput(
                    value = state.registroDto.apellidoPaterno,
                    onValueChange = {
                        viewModel.onValueChange(
                            state.registroDto.copy(
                                apellidoPaterno = it
                            )
                        )
                    },
                    placeholder = stringResource(id = R.string.first_lastname_field_form)
                )
                TextoInput(
                    value = state.registroDto.apellidoMaterno,
                    onValueChange = {
                        viewModel.onValueChange(
                            state.registroDto.copy(
                                apellidoMaterno = it
                            )
                        )
                    },
                    placeholder = stringResource(id = R.string.second_lastname_field_form)
                )
                TextoInput(
                    value = state.registroDto.dni,
                    onValueChange = {
                        viewModel.onValueChange(
                            state.registroDto.copy(
                                dni = it
                            )
                        )
                    },
                    placeholder = stringResource(id = R.string.dni_field_form)
                )
                TextoInput(
                    value = state.registroDto.direccion, onValueChange = {
                        viewModel.onValueChange(
                            state.registroDto.copy(
                                direccion = it
                            )
                        )
                    }, placeholder = stringResource(
                        id = R.string.direction_field_form
                    )
                )
                TextoInput(
                    value = state.registroDto.genero, onValueChange = {
                        viewModel.onValueChange(
                            state.registroDto.copy(
                                genero = it
                            )
                        )
                    }, placeholder = stringResource(
                        id = R.string.genre_field_form
                    )
                )
                TextoInput(
                    value = state.registroDto.tipo_sangre, onValueChange = {
                        viewModel.onValueChange(
                            state.registroDto.copy(
                                tipo_sangre = it
                            )
                        )
                    }, placeholder = stringResource(
                        id = R.string.blood_type_field_form
                    )
                )
                EmailInput(
                    value = state.registroDto.correo,
                    onValueChange = {
                        viewModel.onValueChange(
                            state.registroDto.copy(
                                correo = it
                            )
                        )
                    },
                    placeholder = stringResource(id = R.string.username_field_form)
                )
                ContrasenaInput(value = state.registroDto.contrasenia, onValueChange = {
                    viewModel.onValueChange(
                        state.registroDto.copy(
                            contrasenia = it
                        )
                    )
                })
                ContrasenaInput(
                    value = state.registroDto.contrasenia2, onValueChange = {
                        viewModel.onValueChange(
                            state.registroDto.copy(
                                contrasenia2 = it
                            )
                        )
                    },
                    placeholder = stringResource(id = R.string.repeat_password_field_form)
                )
                BotonFormulario(
                    buttonEnabled = state.botonActivo,
                    onClick = {
                        viewModel.onRegistroSelected(navController = navController)
                    },
                    text = stringResource(id = R.string.register_button_form)
                )
            }

            item {
                Divider(color = MaterialTheme.colors.onSecondary, thickness = 1.dp)
                LoginTexto(navController = navController)
            }
        }
    }
}

@Composable
@Preview(name = "Modo Claro")
@Preview(name = "Modo Oscuro", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewVistaRegistro() {
    AppClinicaUnmsmTheme {
        VistaRegistro(navController = rememberNavController())
    }
}