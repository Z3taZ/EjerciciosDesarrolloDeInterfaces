package com.example.Clase.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable

fun CalculadoraEjemplo(modifier: Modifier = Modifier){

    var n1 by rememberSaveable { mutableStateOf("") }

    var n2 by rememberSaveable { mutableStateOf("") }

    var res by rememberSaveable { mutableStateOf("") }

    //El valor de botonHabilitado será true si el var n1 y el var n2 no tiene contenido null
    val botonHabilitado = n1.toIntOrNull() != null && n2.toIntOrNull() !=null

    Column(
        modifier = modifier
        .fillMaxSize()
        .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Calculadora",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
        //spacer deja un espacio de 32dp entre el text y la siguiente cosa. En este caso
        //Es la siguiente cosa que esté debajo ya que el text está dentro de un column
        Spacer(Modifier.height(32.dp))

        //OutLinedTextField es la caja de texto la cual tendrá
        //los valores que les hemos asignado a n1
        OutlinedTextField(
            value = n1,
            onValueChange = {
                //It es el valor que nos devuelve al escribir dentro de la caja de texto.
                //con it.all cojemos todos los caracteres dentro de esa caja
                //dentro de it.all creamos la variable caracter la cual recorrerá todo el
                //it.all y en caso de que caracter sea un digito (valor 0-9) la variable
                //var n1 será igual a lo que esté escrito dentro de la caja de texto y por ende
                //se mostrará dentro de la caja de texto
                if(it.all{ caracter -> caracter.isDigit()})
                    n1 = it
            },
            label = {Text("Primer número")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            //singleLine obliga al usuario que solamente pueda
            //escribir una linea y no varias dentro de la caja de texto
            singleLine = true,
            modifier = modifier.fillMaxWidth()

        )

        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = n2,
            onValueChange = {
                if(it.all{ caracter -> caracter.isDigit()})
                    n2 = it
            },
            label = {Text("Segundo número número")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            //singleLine obliga al usuario que solamente pueda
            //escribir una linea y no varias dentro de la caja de texto
            singleLine = true,
            modifier = modifier.fillMaxWidth()

        )


        Spacer(Modifier.height(16.dp))
        Button(
            //onClick significa que se ejecutará cuando haga click
            //En ese momento la variable res tendrá el valor de n1 y n2 y lo pasará a String
           onClick = {
               res = (n1.toInt() + n2.toInt()).toString()
           },
            //El botón estará habilitado dependiendo del valor  de la
            //variable botonHabilitado. La cual usa un condicional para dictar si es true or false
            enabled = botonHabilitado,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ){
            Text(text = "SUMAR",
                fontSize = 18.sp)
        }

        Spacer(Modifier.height(16.dp))
        //En caso de que la variable tenga valor (es decir que se cumplan las condiciones para que se sumen ambas variable sde ambos campos)
        //Se creará/aparecerá una columna la cual contiene El texto resultado y otro texto cuyo contenido es el de la variable text
        if(res.isNotEmpty()){
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
               horizontalAlignment = Alignment.CenterHorizontally ) {

                Text(
                    "RESULTADO",
                    fontSize = 24.sp)

                Text(
                    res,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold
                )

            }
        }

        Spacer(Modifier.height(16.dp))
        Button(

            onClick = {
                res = (n1.toInt() / n2.toInt()).toString()
            },
            //El botón estará habilitado dependiendo de la condición que hemos planteado
            //La condicion es que será true en caso de que n1 (campo 1) sea distinto de null, n2 distinto de null y que n2 sea distinto a 0
            enabled = n1.toIntOrNull() != null && n2.toIntOrNull()!=null && n2.toInt()!=0,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ){
            Text(text = "DIVIDIR",
                fontSize = 18.sp)
        }
    }
}