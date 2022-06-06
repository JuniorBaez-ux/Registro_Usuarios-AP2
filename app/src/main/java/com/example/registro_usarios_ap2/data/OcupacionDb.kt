package com.example.registro_usarios_ap2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.registro_usarios_ap2.model.Ocupacion

@Database(
    entities = [Ocupacion::class],
    version = 2
)

abstract class OcupacionDb: RoomDatabase() {
    abstract  val ocupacionDao: OcupacionDao
}