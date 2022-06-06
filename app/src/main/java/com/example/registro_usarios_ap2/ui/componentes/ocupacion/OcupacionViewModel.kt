package com.example.registro_usarios_ap2.ui.componentes.ocupacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registro_usarios_ap2.data.repository.OcupacionRepository
import com.example.registro_usarios_ap2.model.Ocupacion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OcupacionViewModel @Inject constructor(
    val ocupacionRepository: OcupacionRepository
): ViewModel() {

    var nombre by mutableStateOf("")

    var ocupaciones = ocupacionRepository.GetLista()

    fun Guardar(){
        viewModelScope.launch {
            ocupacionRepository.Insertar(
                Ocupacion(
                    descripcion = nombre
                )
            )
        }
    }
}