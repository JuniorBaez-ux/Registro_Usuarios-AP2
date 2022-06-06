package com.example.registro_usarios_ap2.ui.componentes.cliente

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
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
    viewModel: ClienteViewModel = hiltViewModel()
) {

    var balance = viewModel.balance;
    val ocup = listOf("Maestro", "Ingeniero", "Doctor", "Carpinterio")
    Column(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = viewModel.nombre,
            onValueChange = {viewModel.nombre = it},
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
            value = viewModel.email,
            onValueChange = {viewModel.email = it},
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

     /*   OutlinedTextField(
            value = balance,
            onValueChange = {balance = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Salario")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null)
            }
        )*/

        OutlinedButton(
            onClick = {
                viewModel.Guardar()

                navHostController.navigateUp()
            }
        ) {
            Text(text = "Guardar")
        }
    }
}