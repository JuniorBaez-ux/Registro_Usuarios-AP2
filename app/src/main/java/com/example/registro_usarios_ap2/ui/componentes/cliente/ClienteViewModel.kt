package com.example.registro_usarios_ap2.ui.componentes.cliente

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registro_usarios_ap2.data.repository.ClienteRepository
import com.example.registro_usarios_ap2.model.Cliente
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClienteViewModel @Inject constructor(
    val clienteRepository: ClienteRepository
): ViewModel() {

    var clienteID by mutableStateOf(0)
    var nombre by mutableStateOf("")
    var email by mutableStateOf("")
    var ocupacionId by mutableStateOf(0)
    var balance: Double by mutableStateOf(0.0)

    fun Guardar(){
        viewModelScope.launch {
            clienteRepository.Insertar(
                Cliente(
                    clienteId = clienteID,
                    nombre = nombre,
                    email = email,
                    ocupacionId = ocupacionId,
                    balance = balance
                )
            )
        }
    }
}