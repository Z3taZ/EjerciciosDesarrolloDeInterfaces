package com.example.Clase.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun MyColumn(modifier: Modifier = Modifier){

    //Column es un componente como el box que yo puedo poner dentro cosas.
    //Sin embargo, lo pondrá en formato columna
    Column(modifier= modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
        //el Weight se refiere a la cantidad que va a ocupar cada texto dentro del column.
        Text("1", modifier=Modifier.background(Color.Green).weight(1f), fontSize = 24.sp)
        Text("2", modifier=Modifier.background(Color.Blue).weight(2f).fillMaxWidth())
        Text("3", modifier=Modifier.background(Color.Yellow).weight(5f))
        Text("4", modifier=Modifier.background(Color.Cyan).weight(0.6f))
        Text("5", modifier=Modifier.background(Color.Red).weight(0.6f))
        Text("6", modifier=Modifier.background(Color.Green).weight(0.6f))
        Text("7", modifier=Modifier.background(Color.Cyan).weight(0.6f))
        Text("8", modifier=Modifier.background(Color.Green).weight(0.6f))

        Row(modifier.fillMaxWidth().weight(2f)){
            Box(modifier= Modifier
                .fillMaxSize()
                .background(Color.Gray).weight(1f)
            ){

                Text("box 1",
                    color = Color.White,
                    fontSize = 24.sp)
            }
            Box(modifier= Modifier
                .fillMaxSize()
                .background(Color.Black).weight(1f)
            ){

                Text("box 2",
                    color = Color.White,
                    fontSize = 24.sp)
            }
        }
    }
}