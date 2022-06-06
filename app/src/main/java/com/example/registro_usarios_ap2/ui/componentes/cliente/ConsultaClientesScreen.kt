package com.example.registro_usarios_ap2.ui.componentes.cliente

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.registro_usarios_ap2.RowPersona


@Composable
fun ConsultaClientesScreen(navHostController: NavHostController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Consulta de Personas")}
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navHostController.navigate("RegistroClientes")
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

    ) {
        Column(modifier = Modifier.padding(it).padding(8.dp)) {
            Button(onClick = { navHostController.navigate("ConsultaOcupaciones") }) {
                Text(text = "Nueva Ocupación")
            }
            val lista = listOf("Junior", "Stephany", "Darianna", "Goku")

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(lista){
                        nombre -> RowPersona(nombre = nombre)
                }
            }
        }
    }

}