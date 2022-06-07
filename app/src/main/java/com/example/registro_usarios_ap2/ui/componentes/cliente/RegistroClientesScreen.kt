package com.example.registro_usarios_ap2.ui.componentes.cliente

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.registro_usarios_ap2.OcupacionesSpinner

@Composable
fun RegistroClientesScreen(
    navHostController: NavHostController,
    clienteViewModel: ClienteViewModel = hiltViewModel()
) {

    val ocup = listOf("Maestro", "Ingeniero", "Doctor", "Carpinterio")

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Registro de Personas") }) }
    ){


    Column(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = clienteViewModel.nombre,
            onValueChange = {clienteViewModel.nombre = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nombre de la Persona")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null)
            }
        )

        OutlinedTextField(
            value = clienteViewModel.email,
            onValueChange = {clienteViewModel.email = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null)
            }
        )

        OcupacionesSpinner(ocupacion = ocup)

        OutlinedTextField(

            value = clienteViewModel.balance,
            onValueChange = {clienteViewModel.balance = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Salario")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null)
            }
        )

        OutlinedButton(
            onClick = {
                clienteViewModel.Guardar()

                navHostController.navigateUp()
            }
        ) {
            Text(text = "Guardar")
        }
    }
    }
}