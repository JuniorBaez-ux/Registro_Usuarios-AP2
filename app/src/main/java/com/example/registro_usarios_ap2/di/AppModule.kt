package com.example.registro_usarios_ap2.di

import android.content.Context
import androidx.room.Room
import com.example.registro_usarios_ap2.data.*
import com.example.registro_usarios_ap2.data.repository.ClienteRepository
import com.example.registro_usarios_ap2.data.repository.OcupacionRepository
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

    @Singleton
    @Provides
    fun ProvideOcupacionDb(@ApplicationContext context: Context): OcupacionDb {
        val DATABASE_NAME = "OcupacionDb"
        return Room.databaseBuilder(
            context,
            OcupacionDb::class.java,
            DATABASE_NAME       )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun ProvideClienteDAO(prestamosDb: ClientesDb): ClienteDao {
        return prestamosDb.clienteDao
    }

    @Provides
    fun ProvideClienteRepository(clienteDao: ClienteDao): ClienteRepository {
        return ClienteRepository(clienteDao)
    }

    @Provides
    fun ProvideOcupacionDAO(prestamosDb: OcupacionDb): OcupacionDao {
        return prestamosDb.ocupacionDao
    }

    @Provides
    fun ProvideOcupacionRepository(ocupacionDao: OcupacionDao): OcupacionRepository {
        return OcupacionRepository(ocupacionDao)
    }
}