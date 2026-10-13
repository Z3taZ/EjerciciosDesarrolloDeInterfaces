package com.example.Clase.Calculadora

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview
@Composable
fun Calculadora(modifier: Modifier = Modifier) {

    // Color rojo suave menos agresivo a la vista
    val colorRojoSuave = Color(0xFFE57373)

    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF4CAF50))
    ) {
        val (boxNumbers, boxTexto) = createRefs()
        val detener = rememberCoroutineScope()
        var colorBotonContainer by remember { mutableStateOf<Int?>(null) }
        var colorBotonContent by remember { mutableStateOf<Int?>(null) }
        var colorBoton2 by remember { mutableStateOf<Int?>(null) }

        // Variables para gestionar la calculadora
        var texto by rememberSaveable { mutableStateOf("") }
        var primerNumero by rememberSaveable { mutableStateOf("") }
        var operador by rememberSaveable { mutableStateOf("") }
        var segundoNumero by rememberSaveable { mutableStateOf("") }
        var operacionAnterior by rememberSaveable { mutableStateOf("") }

        // Texto justo por encima de la caja de números
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 8.dp)
                .constrainAs(boxTexto) {
                    bottom.linkTo(boxNumbers.top)
                    end.linkTo(parent.end)
                }
        ) {
            if (operacionAnterior.isNotEmpty()) {
                Text(
                    text = operacionAnterior,
                    fontSize = 22.sp,
                    color = Color(0xFF1B3B1B)
                )
            }
            Text(
                text = if (texto.isEmpty()) "0" else texto,
                fontSize = if (texto == "Texto Demasiado largo") 27.sp else 42.sp,
                color = Color.Black,
                maxLines = 1
            )
        }

        // Teclado inferior ocupando más pantalla (65% del alto)
        Column(
            modifier = Modifier
                .border(4.dp, Color.Yellow, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .fillMaxHeight(0.65f)
                .fillMaxWidth()
                .background(Color.White)
                .padding(20.dp)
                .constrainAs(boxNumbers) {
                    bottom.linkTo(parent.bottom)
                }
        ) {

            // FILA 1: 7, 8, 9, +
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.5f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                // BOTÓN 7
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        if (texto != "Texto Demasiado largo") {
                            if (operador.isEmpty()) {
                                primerNumero += "7"
                                texto = primerNumero
                            } else {
                                segundoNumero += "7"
                                texto = "$primerNumero $operador $segundoNumero"
                            }

                            if (texto.length > 15) {
                                texto = "Texto Demasiado largo"
                            }
                        }

                        detener.launch {
                            colorBotonContainer = 7
                            colorBoton2 = 7
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == 7) Color.Green else if (colorBoton2 == 8 || colorBoton2 == 9 || colorBoton2 == 4 || colorBoton2 == 1) colorRojoSuave else Color.Black,
                        contentColor = if (colorBotonContainer == 7) Color.Black else Color.Green,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == 7) Color.Black else Color.Green,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("7", fontSize = 28.sp)
                }

                // BOTÓN 8
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        if (texto != "Texto Demasiado largo") {
                            if (operador.isEmpty()) {
                                primerNumero += "8"
                                texto = primerNumero
                            } else {
                                segundoNumero += "8"
                                texto = "$primerNumero $operador $segundoNumero"
                            }

                            if (texto.length > 15) {
                                texto = "Texto Demasiado largo"
                            }
                        }

                        detener.launch {
                            colorBotonContainer = 8
                            colorBoton2 = 8
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == 8) Color.Green else if (colorBoton2 == 7 || colorBoton2 == 9 || colorBoton2 == 5 || colorBoton2 == 2 || colorBoton2 == 0) colorRojoSuave else Color.Black,
                        contentColor = if (colorBotonContainer == 8) Color.Black else Color.Green,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == 8) Color.Black else Color.Green
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("8", fontSize = 28.sp)
                }

                // BOTÓN 9
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        if (texto != "Texto Demasiado largo") {
                            if (operador.isEmpty()) {
                                primerNumero += "9"
                                texto = primerNumero
                            } else {
                                segundoNumero += "9"
                                texto = "$primerNumero $operador $segundoNumero"
                            }

                            if (texto.length > 15) {
                                texto = "Texto Demasiado largo"
                            }
                        }

                        detener.launch {
                            colorBotonContainer = 9
                            colorBoton2 = 9
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == 9) Color.Green else if (colorBoton2 == 7 || colorBoton2 == 8 || colorBoton2 == 6 || colorBoton2 == 3) colorRojoSuave else Color.Black,
                        contentColor = if (colorBotonContainer == 9) Color.Black else Color.Green,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == 9) Color.Black else Color.Green
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("9", fontSize = 28.sp)
                }

                // BOTÓN +
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        if (texto != "Texto Demasiado largo" && primerNumero.isNotEmpty()) {
                            operador = "+"
                            texto = "$primerNumero $operador"

                            if (texto.length > 15) {
                                texto = "Texto Demasiado largo"
                            }
                        }

                        detener.launch {
                            colorBotonContainer = -7
                            colorBoton2 = -7
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == -7) Color.Blue else Color.Black,
                        contentColor = if (colorBotonContainer == -7) Color.Black else Color.Blue,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == -7) Color.Black else Color.Blue,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("+", fontSize = 28.sp)
                }
            }

            // FILA 2: 4, 5, 6, -
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.5f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                // BOTÓN 4
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        if (texto != "Texto Demasiado largo") {
                            if (operador.isEmpty()) {
                                primerNumero += "4"
                                texto = primerNumero
                            } else {
                                segundoNumero += "4"
                                texto = "$primerNumero $operador $segundoNumero"
                            }

                            if (texto.length > 15) {
                                texto = "Texto Demasiado largo"
                            }
                        }

                        detener.launch {
                            colorBotonContainer = 4
                            colorBoton2 = 4
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == 4) Color.Green else if (colorBoton2 == 5 || colorBoton2 == 7 || colorBoton2 == 6 || colorBoton2 == 1) colorRojoSuave else Color.Black,
                        contentColor = if (colorBotonContainer == 4) Color.Black else Color.Green,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == 4) Color.Black else Color.Green,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("4", fontSize = 28.sp)
                }

                // BOTÓN 5
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        if (texto != "Texto Demasiado largo") {
                            if (operador.isEmpty()) {
                                primerNumero += "5"
                                texto = primerNumero
                            } else {
                                segundoNumero += "5"
                                texto = "$primerNumero $operador $segundoNumero"
                            }

                            if (texto.length > 15) {
                                texto = "Texto Demasiado largo"
                            }
                        }

                        detener.launch {
                            colorBotonContainer = 5
                            colorBoton2 = 5
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == 5) Color.Green else if (colorBoton2 == 4 || colorBoton2 == 8 || colorBoton2 == 6 || colorBoton2 == 2 || colorBoton2 == 0) colorRojoSuave else Color.Black,
                        contentColor = if (colorBotonContainer == 5) Color.Black else Color.Green,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == 5) Color.Black else Color.Green,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("5", fontSize = 28.sp)
                }

                // BOTÓN 6
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        if (texto != "Texto Demasiado largo") {
                            if (operador.isEmpty()) {
                                primerNumero += "6"
                                texto = primerNumero
                            } else {
                                segundoNumero += "6"
                                texto = "$primerNumero $operador $segundoNumero"
                            }

                            if (texto.length > 15) {
                                texto = "Texto Demasiado largo"
                            }
                        }

                        detener.launch {
                            colorBotonContainer = 6
                            colorBoton2 = 6
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == 6) Color.Green else if (colorBoton2 == 5 || colorBoton2 == 9 || colorBoton2 == 4 || colorBoton2 == 3) colorRojoSuave else Color.Black,
                        contentColor = if (colorBotonContainer == 6) Color.Black else Color.Green,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == 6) Color.Black else Color.Green,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("6", fontSize = 28.sp)
                }

                // BOTÓN -
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        if (texto != "Texto Demasiado largo" && primerNumero.isNotEmpty()) {
                            operador = "-"
                            texto = "$primerNumero $operador"

                            if (texto.length > 15) {
                                texto = "Texto Demasiado largo"
                            }
                        }

                        detener.launch {
                            colorBotonContainer = -6
                            colorBoton2 = -6
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == -6) Color.Blue else Color.Black,
                        contentColor = if (colorBotonContainer == -6) Color.Black else Color.Blue,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == -6) Color.Black else Color.Blue,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("-", fontSize = 28.sp)
                }
            }

            // FILA 3: 1, 2, 3, *
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.5f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                // BOTÓN 1
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        if (texto != "Texto Demasiado largo") {
                            if (operador.isEmpty()) {
                                primerNumero += "1"
                                texto = primerNumero
                            } else {
                                segundoNumero += "1"
                                texto = "$primerNumero $operador $segundoNumero"
                            }

                            if (texto.length > 15) {
                                texto = "Texto Demasiado largo"
                            }
                        }

                        detener.launch {
                            colorBotonContainer = 1
                            colorBoton2 = 1
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == 1) Color.Green else if (colorBoton2 == 2 || colorBoton2 == 3 || colorBoton2 == 4 || colorBoton2 == 7) colorRojoSuave else Color.Black,
                        contentColor = if (colorBotonContainer == 1) Color.Black else Color.Green,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == 1) Color.Black else Color.Green,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("1", fontSize = 28.sp)
                }

                // BOTÓN 2
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        if (texto != "Texto Demasiado largo") {
                            if (operador.isEmpty()) {
                                primerNumero += "2"
                                texto = primerNumero
                            } else {
                                segundoNumero += "2"
                                texto = "$primerNumero $operador $segundoNumero"
                            }

                            if (texto.length > 15) {
                                texto = "Texto Demasiado largo"
                            }
                        }

                        detener.launch {
                            colorBotonContainer = 2
                            colorBoton2 = 2
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == 2) Color.Green else if (colorBoton2 == 1 || colorBoton2 == 3 || colorBoton2 == 5 || colorBoton2 == 8 || colorBoton2 == 0) colorRojoSuave else Color.Black,
                        contentColor = if (colorBotonContainer == 2) Color.Black else Color.Green,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == 2) Color.Black else Color.Green,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("2", fontSize = 28.sp)
                }

                // BOTÓN 3
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        if (texto != "Texto Demasiado largo") {
                            if (operador.isEmpty()) {
                                primerNumero += "3"
                                texto = primerNumero
                            } else {
                                segundoNumero += "3"
                                texto = "$primerNumero $operador $segundoNumero"
                            }

                            if (texto.length > 15) {
                                texto = "Texto Demasiado largo"
                            }
                        }

                        detener.launch {
                            colorBotonContainer = 3
                            colorBoton2 = 3
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == 3) Color.Green else if (colorBoton2 == 1 || colorBoton2 == 2 || colorBoton2 == 6 || colorBoton2 == 9) colorRojoSuave else Color.Black,
                        contentColor = if (colorBotonContainer == 3) Color.Black else Color.Green,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == 3) Color.Black else Color.Green,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("3", fontSize = 28.sp)
                }

                // BOTÓN *
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        if (texto != "Texto Demasiado largo" && primerNumero.isNotEmpty()) {
                            operador = "*"
                            texto = "$primerNumero $operador"

                            if (texto.length > 15) {
                                texto = "Texto Demasiado largo"
                            }
                        }

                        detener.launch {
                            colorBotonContainer = -5
                            colorBoton2 = -5
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == -5) Color.Blue else Color.Black,
                        contentColor = if (colorBotonContainer == -5) Color.Black else Color.Blue,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == -5) Color.Black else Color.Blue,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("*", fontSize = 28.sp)
                }
            }

            // FILA 4: DEL, 0, =, /
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.5f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                // BOTÓN DEL
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        primerNumero = ""
                        operador = ""
                        segundoNumero = ""
                        operacionAnterior = ""
                        texto = ""

                        detener.launch {
                            colorBotonContainer = -1
                            colorBoton2 = -1
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == -1) Color.Blue else Color.Black,
                        contentColor = if (colorBotonContainer == -1) Color.Black else Color.Blue,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == -1) Color.Black else Color.Blue,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("DEL", fontSize = 16.sp, maxLines = 1)
                }

                // BOTÓN 0
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        if (texto != "Texto Demasiado largo") {
                            if (operador.isEmpty()) {
                                primerNumero += "0"
                                texto = primerNumero
                            } else {
                                segundoNumero += "0"
                                texto = "$primerNumero $operador $segundoNumero"
                            }

                            if (texto.length > 15) {
                                texto = "Texto Demasiado largo"
                            }
                        }

                        detener.launch {
                            colorBotonContainer = 0
                            colorBoton2 = 0
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == 0) Color.Green else if (colorBoton2 == 2 || colorBoton2 == 5 || colorBoton2 == 8) colorRojoSuave else Color.Black,
                        contentColor = if (colorBotonContainer == 0) Color.Black else Color.Green,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == 0) Color.Black else Color.Green,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("0", fontSize = 28.sp)
                }

                // BOTÓN =
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        if (texto != "Texto Demasiado largo") {
                            val num1 = primerNumero.toDoubleOrNull()
                            val num2 = segundoNumero.toDoubleOrNull()

                            if (num1 != null && num2 != null) {
                                operacionAnterior = "$primerNumero $operador $segundoNumero"

                                if (operador == "/" && num2 == 0.0) {
                                    texto = "Error"
                                    primerNumero = ""
                                    operador = ""
                                    segundoNumero = ""
                                } else {
                                    val resultado = when (operador) {
                                        "+" -> num1 + num2
                                        "-" -> num1 - num2
                                        "*" -> num1 * num2
                                        "/" -> num1 / num2
                                        else -> 0.0
                                    }

                                    val textoResultado = if (resultado % 1.0 == 0.0) {
                                        resultado.toLong().toString()
                                    } else {
                                        resultado.toString()
                                    }

                                    if (textoResultado.length > 15) {
                                        texto = "Texto Demasiado largo"
                                    } else {
                                        texto = textoResultado
                                        primerNumero = textoResultado
                                        operador = ""
                                        segundoNumero = ""
                                    }
                                }
                            }
                        }

                        detener.launch {
                            colorBotonContainer = -3
                            colorBoton2 = -3
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == -3) Color.Blue else Color.Black,
                        contentColor = if (colorBotonContainer == -3) Color.Black else Color.Blue,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == -3) Color.Black else Color.Blue,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("=", fontSize = 28.sp)
                }

                // BOTÓN /
                Button(
                    modifier = Modifier.width(80.dp).height(80.dp),
                    onClick = {
                        if (texto != "Texto Demasiado largo" && primerNumero.isNotEmpty()) {
                            operador = "/"
                            texto = "$primerNumero $operador"

                            if (texto.length > 15) {
                                texto = "Texto Demasiado largo"
                            }
                        }

                        detener.launch {
                            colorBotonContainer = -2
                            colorBoton2 = -2
                            delay(100)
                            colorBotonContent = null
                            colorBotonContainer = null
                            colorBoton2 = null
                        }
                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (colorBotonContainer == -2) Color.Blue else Color.Black,
                        contentColor = if (colorBotonContainer == -2) Color.Black else Color.Blue,
                    ),
                    border = BorderStroke(
                        width = 3.dp,
                        if (colorBotonContainer == -2) Color.Black else Color.Blue,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("/", fontSize = 28.sp)
                }
            }
        }
    }
}
