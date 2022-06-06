package com.example.registro_usarios_ap2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.registro_usarios_ap2.model.Cliente

@Database(
    entities = [Cliente::class],
    version = 1
)
abstract class ClientesDb: RoomDatabase() {
    abstract  val clienteDao: ClienteDao

}