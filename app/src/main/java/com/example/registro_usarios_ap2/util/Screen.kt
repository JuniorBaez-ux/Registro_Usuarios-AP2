package com.example.registro_usarios_ap2.util

 sealed class Screen(val route: String) {
     object RegistroPersonaScreen: Screen("Registropersonas")
     object ListadoPersonaScreen: Screen("Listadopersonas")

     object RegistroOcupacionesScreen: Screen("RegistroOcupaciones")
     object ListadoOcupacionesScreen: Screen("ListadoOcupacionesScreen")

}