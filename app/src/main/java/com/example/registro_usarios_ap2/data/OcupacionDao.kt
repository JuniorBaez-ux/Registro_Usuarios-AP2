package com.example.registro_usarios_ap2.data

import androidx.room.*
import com.example.registro_usarios_ap2.model.Ocupacion
import kotlinx.coroutines.flow.Flow

@Dao
interface OcupacionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(ocupacion: Ocupacion)

    @Delete
    suspend fun Eliminar(ocupacion: Ocupacion)


    @Query("""
        SELECT * 
        FROM Ocupaciones
        WHERE ocupacionId=:ocupacionId        
    """)
    fun Buscar(ocupacionId: Int): Flow<Ocupacion>

    @Query("""
        SELECT * 
        FROM Ocupaciones
        ORDER BY ocupacionId    
    """)
    fun GetLista(): Flow<List<Ocupacion>>

}