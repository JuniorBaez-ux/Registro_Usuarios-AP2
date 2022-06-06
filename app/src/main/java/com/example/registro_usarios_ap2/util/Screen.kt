package com.example.registro_usarios_ap2.util

 sealed class Screen(val route: String) {
     object RegistroPersonaScreen: Screen("Registropersonas")
     object ConsultaClientesScreen: Screen("ConsultaClientes")

     object RegistroOcupacionesScreen: Screen("RegistroOcupaciones")
     object ConsultaOcupacionesScreen: Screen("ConsultaOcupaciones")

}