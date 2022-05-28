package com.example.registro_usarios_ap2.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Clientes")
@Parcelize
data class Cliente(
    @PrimaryKey(autoGenerate = true)
    val clienteId: Int,
    val nombre: String,
    val email: String,
    val ocupacionId: Int,
    val balance: Float
): Parcelable
