package com.example.registro_usarios_ap2.di

import android.content.Context
import androidx.room.Room
import com.example.registro_usarios_ap2.data.ClienteDao
import com.example.registro_usarios_ap2.data.ClientesDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object  AppModule {


    @Singleton
    @Provides
    fun ProvideTicketDb(@ApplicationContext context: Context): ClientesDb {
        val DATABASE_NAME = "ClientesDb"
        return Room.databaseBuilder(
            context,
            ClientesDb::class.java,
            DATABASE_NAME       )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun ProvideClienteDAO(prestamosDb: ClientesDb): ClienteDao {
        return prestamosDb.clienteDao
    }

}