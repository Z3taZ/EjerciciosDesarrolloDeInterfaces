package com.example.Clase.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



//@Composable es para indicar que vas a dibujar algo por pantalla
@Composable
//modifier sirve para modificar un componente. en este caso sería el box
//modifier es el parámetro y Modifier es el tipo de parametro. es como
//decir en java String string pero en este caso es al revés.
//Está diciendo que la función puede recibir un modifier ya hecho, pero
//que en caso de que no sea así recibirá uno por defecto vacío
fun MyBox(modifier: Modifier = Modifier) {

    //Box es la caja roja, es decir, que aquí meterás lo que quieres que se vea
    //por pantalla
    Box(
        //aquí está indicando que el box usará un modifier por defecto vacío
        modifier = modifier
            //comando para hacer que ocupe toda la pantalla tanto en x como en y
            .fillMaxSize()
            .background(Color.Red),
            //le indica el contentAlignment donde se colocará el contenido de la caja
            //en este caso será en el centro
            contentAlignment = Alignment.Center
    ) {
        //Texto que aparece por pantalla dentro del primer box
       /* Text("hola",
            color = Color.Black,
            fontSize = 24.sp)


        */
        Box(modifier= Modifier
            .width(100.dp)
            .height(100.dp)
            .background(Color.Blue)
        ){

            Text("este es otro box",
                color = Color.White,
                fontSize = 24.sp)
        }
    }
}