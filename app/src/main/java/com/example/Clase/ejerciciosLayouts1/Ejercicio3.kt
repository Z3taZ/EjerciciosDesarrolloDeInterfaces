package com.example.Clase.ejerciciosLayouts1

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun Ejercicio3(modifier: Modifier = Modifier){

    Column(modifier = Modifier.fillMaxSize().background(Color.Black).border(20.dp,color=Color.Black).padding(20.dp)) {

        Row(modifier=Modifier.fillMaxSize().weight(1f)) {
            Box(modifier=Modifier.fillMaxSize().background(Color.Blue).weight(0.5f).padding(10.dp), contentAlignment = Alignment.TopStart){
                Text("Blue",color=Color.White, fontSize = 24.sp)
            }
            Box(modifier=Modifier.fillMaxSize().background(Color.Magenta).weight(0.5f).padding(10.dp), contentAlignment = Alignment.TopStart){
                Text("Magenta",color=Color.White, fontSize = 24.sp)

            }
        }
        Row(modifier=Modifier.fillMaxSize().weight(1f)) {
            Box(modifier=Modifier.fillMaxSize().background(Color.Yellow).weight(0.5f).padding(10.dp), contentAlignment = Alignment.TopStart){
                Text("Yellow",color=Color.White, fontSize = 24.sp)
            }
            Box(modifier=Modifier.fillMaxSize().background(Color.Green).weight(0.5f).padding(10.dp), contentAlignment = Alignment.TopStart){
                Text("Green",color=Color.White, fontSize = 24.sp)

            }
        }
        Row(modifier=Modifier.fillMaxSize().weight(1f)) {
            Box(modifier=Modifier.fillMaxSize().background(Color.Gray).weight(0.5f).padding(10.dp), contentAlignment = Alignment.TopStart){
                Text("Gray",color=Color.White, fontSize = 24.sp)
            }
            Box(modifier=Modifier.fillMaxSize().background(Color.Cyan).weight(0.5f).padding(10.dp), contentAlignment = Alignment.TopStart){
                Text("Cyan",color=Color.White, fontSize = 24.sp)

            }
        }
        Row(modifier=Modifier.fillMaxSize().weight(1f)) {
            Box(modifier=Modifier.fillMaxSize().background(Color.Red).weight(0.5f).padding(10.dp), contentAlignment = Alignment.TopStart){
                Text("Red",color=Color.White, fontSize = 24.sp)
            }
            Box(modifier=Modifier.fillMaxSize().background(Color.Magenta).weight(0.5f).padding(10.dp), contentAlignment = Alignment.TopStart){
                Text("Magenta",color=Color.White, fontSize = 24.sp)

            }
        }
    }
}