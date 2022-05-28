package com.example.registro_usarios_ap2.viewmodel

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Dao
import com.example.registro_usarios_ap2.data.ClienteDao
import com.example.registro_usarios_ap2.data.ClienteRepository
import com.example.registro_usarios_ap2.model.Cliente
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ClienteViewModel @Inject constructor(
    val repository: ClienteRepository
) : ViewModel(){

    val clientes : Flow<List<Cliente>>
        get() =  repository.GetLista()

    private val _guardado = MutableLiveData(false)
    val guardado: LiveData<Boolean> get() = _guardado

    fun guardar(cliente: Cliente){
        viewModelScope.launch {
            repository.Insertar(cliente)
            _guardado.value=true
        }
    }

}