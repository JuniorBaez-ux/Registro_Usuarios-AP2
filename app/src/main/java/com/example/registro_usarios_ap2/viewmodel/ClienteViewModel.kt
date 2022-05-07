package com.example.registro_usarios_ap2.viewmodel

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Dao
import com.example.registro_usarios_ap2.data.ClienteDao
import com.example.registro_usarios_ap2.model.Cliente
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ClienteViewModel @Inject constructor(
    val clienteDao: ClienteDao
) : ViewModel(){

    private val _guardado = MutableLiveData(false)
    val guardado: LiveData<Boolean> get() = _guardado

    fun guardar(cliente: Cliente){
        viewModelScope.launch {
            clienteDao.Insertar(cliente)
            _guardado.value=true
        }
    }

}