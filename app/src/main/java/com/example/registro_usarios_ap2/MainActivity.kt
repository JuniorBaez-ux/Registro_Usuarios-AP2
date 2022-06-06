package com.example.registro_usarios_ap2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.registro_usarios_ap2.ui.componentes.ocupacion.ConsultaOcupacionesScreen
import com.example.registro_usarios_ap2.ui.componentes.ocupacion.RegistroOcupacionesScreen
import com.example.peopleregistercompose.ui.theme.RegistroPersonaComposeTheme
import com.example.registro_usarios_ap2.ui.componentes.cliente.ConsultaClientesScreen
import com.example.registro_usarios_ap2.ui.componentes.cliente.RegistroClientesScreen
import dagger.hilt.android.AndroidEntryPoint

/*
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}*/

var selectedOcupacion: String? = null

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistroPersonaComposeTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "ConsultaClientes"){
        composable("ConsultaOcupaciones"){
            ConsultaOcupacionesScreen(navHostController = navHostController)
        }
        composable("RegistroOcupaciones"){
            RegistroOcupacionesScreen(navHostController = navHostController)
        }
        composable("ConsultaClientes"){
            ConsultaClientesScreen(navHostController = navHostController)
        }
        composable("RegistroClientes"){
            RegistroClientesScreen(navHostController = navHostController)
        }
    }
}

/*@Composable
fun ConsultaPersonaScreen(navHostController: NavHostController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Consulta de Personas")}
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navHostController.navigate("RegistroPersona")
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

}*/

/*@Composable
fun RegistroPersonaScreen(navHostController: NavHostController){
    var person by rememberSaveable(){
        mutableStateOf("")
    }
    var email by rememberSaveable(){
        mutableStateOf("")
    }
    var salario by rememberSaveable(){
        mutableStateOf("")
    }

    val ocup = listOf("Maestro", "Ingeniero", "Doctor", "Carpinterio")
    Column(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = person,
            onValueChange = {person = it},
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
            value = email,
            onValueChange = {email = it},
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
            value = salario,
            onValueChange = {salario = it},
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

        OutlinedButton(onClick = { navHostController.navigateUp() }) {
            Text(text = "Guardar")
        }
    }
}*/


/*@Composable
fun ListadoPersonasScreen(goRegistroPersonas:() -> Unit, goListaOcupaciones:() -> Unit){

    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar ={
            TopAppBar(title = { Text(text = "Listado de Personas") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    goRegistroPersonas()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Nuevo")
            }
        },
        scaffoldState = ScaffoldState

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Button(onClick = {
                goListaOcupaciones()
            }) {
                Text(text = "Ocupaciones")
            }

            val listaPersonas = listOf("1", "Junior Baez", "Juniorbaez1606@gmail.com", "16,000.00")
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ){
                items(listaPersonas) { persons ->
                    Row() {
                        Text(text = "$persons")
                    }
                }
            }
        }
    }
}*/

@Composable
fun OcupacionesSpinner(ocupacion:List<String>){

    var ocupacionText by remember{
        mutableStateOf("")
    }
    var expended by remember{
        mutableStateOf(false)
    }
    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(Modifier
            .fillMaxWidth()
            .clickable {
                expended = !expended
            }
            .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){

            Text(text = ocupacionText, fontSize = 18.sp, modifier = Modifier.padding(end = 8.dp))
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
            DropdownMenu(expanded = expended, onDismissRequest = { expended = false}) {
                ocupacion.forEach {
                        ocupacion -> DropdownMenuItem(onClick = {

                    expended = false
                    ocupacionText = ocupacion.toString()
                    selectedOcupacion = ocupacion
                }) {
                    Text(text = ocupacion.toString())
                }
                }

            }
        }
    }
}

/*@Composable
fun RegistroPersonasScreen(backToListadoPersonas:() -> Unit){

    var nombres by rememberSaveable() {
        mutableStateOf("")
    }

    var email by rememberSaveable() {
        mutableStateOf("")
    }

    var salario by rememberSaveable() {
        mutableStateOf("")
    }

    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Personas") })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {

            OutlinedTextField(
                value = nombres,
                onValueChange = {nombres = it},
                label = { Text(text = "Nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                label = { Text(text = "Email") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = salario,
                onValueChange = {salario = it},
                label = { Text(text = "Salario") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = {
                backToListadoPersonas()
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {
                Text(text = "Guardar")
            }
        }
    }
}

@Composable
fun ListaOcupacionScreen(goToRegistroOcupaciones:() -> Unit){
    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar ={
            TopAppBar(title = { Text(text = "Listado de Ocupaciones") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    goToRegistroOcupaciones()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Nuevo")
            }
        },
        scaffoldState = ScaffoldState

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            val listaOcupaciones = listOf("1", "Programador")
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ){
                items(listaOcupaciones) { ocupaciones ->
                    Row() {
                        Text(text = "$ocupaciones")
                    }
                }
            }
        }
    }
}

@Composable
fun registrosOcupacionScreen(backToListadoOcupaciones:() -> Unit){
    var ocupacion by rememberSaveable() {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Ocupaciones") })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {

            OutlinedTextField(
                value = ocupacion,
                onValueChange = {ocupacion = it},
                label = { Text(text = "Ocupacion") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = {
                backToListadoOcupaciones()
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {
                Text(text = "Guardar")
            }
        }
    }
}*/

@Composable
fun RowPersona(nombre:String){
    Row() {
        Text(text = "El nombre es: $nombre")
    }
}

@Composable
fun RowOcupacion(ocupacion:String){
    Row() {
        Text(text = "El nombre de la Ocupación es: $ocupacion")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    RegistroPersonaComposeTheme {
        MyApp()
    }
}