package com.example.registro_usarios_ap2.data

import androidx.room.*
import com.example.registro_usarios_ap2.model.Cliente
import kotlinx.coroutines.flow.Flow


@Dao
interface ClienteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(cliente: Cliente)

    @Delete
    suspend fun Eliminar(cliente: Cliente)


    @Query("""
        SELECT * 
        FROM Clientes
        WHERE clienteId=:clienteId        
    """)
    fun Buscar(clienteId: Int): Flow<Cliente>

    @Query("""
        SELECT * 
        FROM Clientes
        ORDER BY clienteId    
    """)
    fun GetLista(): Flow<List<Cliente>>

}