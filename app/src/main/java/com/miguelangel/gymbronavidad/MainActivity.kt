package com.miguelangel.gymbronavidad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.miguelangel.gymbronavidad.ui.theme.GymbronavidadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymbronavidadTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Cyan
                ) {
                    Informacion()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Informacion() {
    var dia by remember { mutableStateOf("") }
    var backSquat by remember { mutableStateOf("") }
    var frontSquat by remember { mutableStateOf("") }
    var benchPress by remember { mutableStateOf("") }
    var deadLift by remember { mutableStateOf("") }
    var kg by remember { mutableStateOf("") }
    var rm by remember { mutableStateOf(0.0) }
    var tupeso by remember { mutableStateOf("") }

    var showDialog by remember { mutableStateOf(true) }

    var backscuadList: MutableList<String> by remember { mutableStateOf(mutableListOf()) }
    var frontSquatList: MutableList<String> by remember { mutableStateOf(mutableListOf()) }
    var benchPressList: MutableList<String> by remember { mutableStateOf(mutableListOf()) }
    var deadLiftList: MutableList<String> by remember { mutableStateOf(mutableListOf()) }

    val selectedOption = remember { mutableStateOf("") }
    // Inicializar listas con cadenas vacías para 30 días
    for (i in 0..29) {
        backscuadList.add("")
        frontSquatList.add("")
        benchPressList.add("")
        deadLiftList.add("")
    }
    // Diseño de la columna principal para la interfaz de usuario
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TextField(
            value = dia,
            onValueChange = { dia = it },
            label = { Text("Introduce el día del mes", color = Color.Green) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = backSquat,
            onValueChange = { backSquat = it },
            label = { Text("Peso de BackSquat", color = Color.Green) },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = frontSquat,
            onValueChange = { frontSquat = it },
            label = { Text("Peso de FrontSquat", color = Color.Green) },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = benchPress,
            onValueChange = { benchPress = it },
            label = { Text("Peso de BenchPress", color = Color.Green) },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = deadLift,
            onValueChange = { deadLift = it },
            label = { Text("Peso de DeadLift", color = Color.Green) },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        // Columna principal para las entradas del usuario
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Botón para ingresar pesos
            Button(
                onClick = {
                    var diaentero = dia.toInt()
                    // Actualizar listas basadas en la entrada del usuario

                    backscuadList[diaentero] = backSquat
                    frontSquatList[diaentero] = frontSquat
                    benchPressList[diaentero] = benchPress
                    deadLiftList[diaentero] = deadLift
                },
                modifier = Modifier.padding(16.dp),
                colors = ButtonDefaults.buttonColors(contentColor = Color.Red)
            ) {
                Text(text = "Ingresar Pesos")
            }
        }

        RadioButtonsSection(selectedOption, showDialog)

        when (selectedOption.value) {
            "Option 1" ->{
                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = {
                            showDialog = false
                        },
                        title = {
                            Text(text = "Estos son los pesos ordenados")
                        },
                        text = {
                            Ordenarporpeso(backscuadList)
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    showDialog = false
                                }
                            ) {
                                Text(text = "OK", color = Color.White)
                            }
                        }
                    )
                }
            }
            "Option 2" ->{
                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = {
                            showDialog = false
                        },
                        title = {
                            Text(text = "Estos son los pesos ordenados")
                        },
                        text = {
                            Ordenarporpeso(frontSquatList)
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    showDialog = false
                                }
                            ) {
                                Text(text = "OK", color = Color.White)
                            }
                        }
                    )
                }
            }
            "Option 3" ->{
                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = {
                            showDialog = false
                        },
                        title = {
                            Text(text = "Estos son los pesos ordenados")
                        },
                        text = {
                            Ordenarporpeso(benchPressList)
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    showDialog = false
                                }
                            ) {
                                Text(text = "OK", color = Color.White)
                            }
                        }
                    )
                }
            }
            "Option 4" ->{
                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = {
                            showDialog = false
                        },
                        title = {
                            Text(text = "Estos son los pesos ordenados")
                        },
                        text = {
                            Ordenarporpeso(deadLiftList)
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    showDialog = false
                                }
                            ) {
                                Text(text = "OK", color = Color.White)
                            }
                        }
                    )
                }
            }
            "Option 5" ->{
                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = {
                            showDialog = false
                        },
                        title = {
                            Text(text = "Estos son los pesos ordenados")
                        },
                        text = {
                            MostrarPesos(backscuadList,frontSquatList,benchPressList,deadLiftList)
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    showDialog = false
                                }
                            ) {
                                Text(text = "OK", color = Color.White)
                            }
                        }
                    )
                }
            }
            "Option 6" ->{
                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = {
                            showDialog = false
                        },
                        title = {
                            Text(text = "Estos son los pesos ordenados")
                        },
                        text = {
                            Dias(backscuadList)
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    showDialog = false
                                }
                            ) {
                                Text(text = "OK", color = Color.White)
                            }
                        }
                    )
                }
            }
            "Option 7" -> {
                TextField(
                    value = kg,
                    onValueChange = {
                        kg = it
                    },
                    label = { Text("Kg realizados") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = androidx.compose.ui.text.input.ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            rm=kg.toInt()/0.80
                            showDialog=true
                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )


                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = {
                            showDialog = false
                        },
                        title = {
                            Text(text = "Informacion")
                        },
                        text = {
                            Text("Rm: $rm \n")
                            if(backscuadList.indexOf(kg)>0){
                                Text("\nEste peso lo has realizado en BackSquad el dia ${backscuadList.indexOf(kg)}\n")
                            }
                            if(frontSquatList.indexOf(kg)>0){
                                Text("\nEste peso lo has realizado en frontSquat el dia ${frontSquatList.indexOf(kg)}\n")
                            }
                            if(benchPressList.indexOf(kg)>0){
                                Text("\nEste peso lo has realizado en benchPress el dia ${benchPressList.indexOf(kg)}\n")
                            }
                            if(deadLiftList.indexOf(kg)>0){
                                Text("\nEste peso lo has realizado en DeadLift el dia ${deadLiftList.indexOf(kg)}\n")
                            }
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    showDialog = false
                                }
                            ) {
                                Text(text = "OK", color = Color.White)
                            }
                        }
                    )
                }
            }
            "Option 8" -> {
                TextField(
                    value = tupeso,
                    onValueChange = {
                        tupeso = it
                    },
                    label = { Text("Tu peso en kg") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = androidx.compose.ui.text.input.ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            showDialog=true
                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = {
                            showDialog = false
                        },
                        title = {
                            Text(text = "¿Eres uno de los 5%?")
                        },
                        text = {
                            Text(masfuerte(backscuadList,benchPressList,deadLiftList,tupeso))
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    showDialog = false
                                }
                            ) {
                                Text(text = "OK", color = Color.White)
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun RadioButtonsSection(selectedOption: MutableState<String>, showDialog: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selectedOption.value == "Option 1",
            onClick = {
                selectedOption.value = "Option 1"
                var showDialog = true
            },
            modifier = Modifier.padding(end = 4.dp)
        )
        Text("Back Squat", color = Color.Black)

        RadioButton(
            selected = selectedOption.value == "Option 2",
            onClick = {
                selectedOption.value = "Option 2"
                var showDialog = true
            },
            modifier = Modifier.padding(start = 16.dp, end = 4.dp)
        )
        Text("Front Squat", color = Color.Black)
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selectedOption.value == "Option 3",
            onClick = {
                selectedOption.value = "Option 3"
                var showDialog = true
            },
            modifier = Modifier.padding(end = 4.dp)
        )
        Text("Bench Press", color = Color.Black)

        RadioButton(
            selected = selectedOption.value == "Option 4",
            onClick = {
                selectedOption.value = "Option 4"
                var showDialog = true
            },
            modifier = Modifier.padding(start = 16.dp, end = 4.dp)
        )
        Text("Dead Lift", color = Color.Black)
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selectedOption.value == "Option 5",
            onClick = {
                selectedOption.value = "Option 5"
                var showDialog = true
            },
            modifier = Modifier.padding(end = 4.dp)
        )
        Text("Progreso de Ejercicios", color = Color.Black)

        RadioButton(
            selected = selectedOption.value == "Option 6",
            onClick = {
                selectedOption.value = "Option 6"
                var showDialog = true
            },
            modifier = Modifier.padding(start = 16.dp, end = 4.dp)
        )
        Text("Entrenamientos", color = Color.Black)
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selectedOption.value == "Option 7",
            onClick = {
                selectedOption.value = "Option 7"
                var showDialog = false
            },
            modifier = Modifier.padding(end = 4.dp)
        )
        Text("RM", color = Color.Black)

        RadioButton(
            selected = selectedOption.value == "Option 8",
            onClick = {
                selectedOption.value = "Option 8"
                var showDialog = true
            },
            modifier = Modifier.padding(start = 16.dp, end = 4.dp)
        )
        Text("Mas Fuerte", color = Color.Black)
    }
}

@Composable
fun Dias(backscuadList: MutableList<String>) {
    var diasentrenados by remember { mutableStateOf(0) }
    diasentrenados = backscuadList.take(30).count { it.isNotBlank() }
    Text(text = diasentrenados.toString())
}

@Composable
fun masfuerte(
    backSquatList: MutableList<String>,
    benchPressList: MutableList<String>,
    deadLiftList: MutableList<String>,
    tuPeso: String
): String {
    try {
        val presslista = benchPressList.map { it.toIntOrNull() ?: 0 }.toMutableList()
        val backscuadlista = backSquatList.map { it.toIntOrNull() ?: 0 }.toMutableList()
        val deadliftlista = deadLiftList.map { it.toIntOrNull() ?: 0 }.toMutableList()

        val peso = tuPeso.toInt() * 1.5
        val deadPeso = tuPeso.toInt() * 2

        return when {
            (presslista.maxOrNull() ?: 0) >= tuPeso.toInt() &&
                    (backscuadlista.maxOrNull() ?: 0) >= peso &&
                    (deadliftlista.maxOrNull() ?: 0) >= deadPeso -> {
                "Eres uno de los 5%"
            }
            else -> {
                "Tienes que hacer más ejercicio"
            }
        }
    } catch (e: NumberFormatException) {
        return "Error: El peso no es un número válido"
    } catch (e: Exception) {
        return "Error inesperado"
    }
}

@Composable
fun Ordenarporpeso(listaOrdenar: MutableList<String>) {
    var listaAuxiliar by remember { mutableStateOf(mutableListOf<String>()) }

    for (i in 0 until minOf(30, listaOrdenar.size)) {
        if (listaOrdenar[i].isNotBlank()) {
            listaAuxiliar.add(listaOrdenar[i])
        }
    }
    listaAuxiliar.sort()
    Text(text = listaAuxiliar.toString())
}

@Composable
fun MostrarPesos(
    backSquatList: MutableList<String>,
    frontSquatList: MutableList<String>,
    benchPressList: MutableList<String>,
    deadLiftList: MutableList<String>
) {
    var listaAuxiliar by remember { mutableStateOf(mutableListOf<String>()) }
    for (i in 0..29) {
        if (backSquatList[i].isNotBlank() ||
            frontSquatList[i].isNotBlank() ||
            benchPressList[i].isNotBlank() ||
            deadLiftList[i].isNotBlank()
        ) {
            listaAuxiliar.add("DIA: $i Back Squat: Peso: ${backSquatList[i]}")
            listaAuxiliar.add("DIA: $i Front Squat: Peso: ${frontSquatList[i]}")
            listaAuxiliar.add("DIA: $i Bench Press: Peso: ${benchPressList[i]}")
            listaAuxiliar.add("DIA: $i Dead Lift: Peso: ${deadLiftList[i]}\n")
        }
    }
    Text(text = listaAuxiliar.toString())
}

