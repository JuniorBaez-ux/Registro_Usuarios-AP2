package com.example.registro_usarios_ap2.ui.componentes.ocupacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun RegistroOcupacionesScreen(
    navHostController: NavHostController,
    ocupacionViewModel: OcupacionViewModel = hiltViewModel()
) {

    Column(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = ocupacionViewModel.nombre,
            onValueChange = { ocupacionViewModel.nombre = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nombre de la Ocupacion")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null
                )
            }
        )

        OutlinedButton(
            onClick = {
                ocupacionViewModel.Guardar()
                navHostController.navigateUp()
            }
        ) {
            Text(text = "Guardar")
        }
    }
}