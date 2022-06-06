package com.example.registro_usarios_ap2.data.repository

import com.example.registro_usarios_ap2.data.ClienteDao
import com.example.registro_usarios_ap2.model.Cliente
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ClienteRepository @Inject constructor(
    val clienteDao: ClienteDao
) {
    suspend fun Insertar(cliente: Cliente)= clienteDao.Insertar(cliente)

    fun Buscar(clienteId: Int): Flow<Cliente>   =  clienteDao.Buscar(clienteId)

    suspend fun Eliminar(cliente: Cliente)= clienteDao.Eliminar(cliente)

    fun GetLista(): Flow<List<Cliente>> = clienteDao.GetLista()
}