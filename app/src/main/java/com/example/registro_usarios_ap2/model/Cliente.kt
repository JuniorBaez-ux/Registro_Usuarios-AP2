package com.example.registro_usarios_ap2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Clientes")
data class Cliente(
    @PrimaryKey(autoGenerate = true)
    val ClienteId: Int,
    val Nombre: String,
    val Balance: Float
)
