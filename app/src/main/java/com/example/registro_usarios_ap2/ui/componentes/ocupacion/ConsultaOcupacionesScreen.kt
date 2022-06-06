package com.example.registro_usarios_ap2.ui.componentes.ocupacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.registro_usarios_ap2.RowOcupacion
import com.example.registro_usarios_ap2.data.repository.OcupacionRepository


@Composable
fun ConsultaOcupacionesScreen(navHostController: NavHostController, ocupacionViewModel: OcupacionViewModel = hiltViewModel()){

    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Consulta de Ocupaciones") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navHostController.navigate("RegistroOcupaciones")
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
                scaffoldState = ScaffoldState
    ) {
        Column(modifier = Modifier.padding(it).padding(8.dp)) {

            val listaocupaciones = ocupacionViewModel.ocupaciones.collectAsState(initial = emptyList())

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(listaocupaciones.value){
                        ocupacion -> RowOcupacion(ocupacion = ocupacion.descripcion)
                }
            }


        }
    }

}