package com.example.Clase.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Preview

fun MyConstraintLayout(modifier: Modifier = Modifier){

    ConstraintLayout(modifier=modifier.fillMaxSize()){

        //En kotlin podemos declarar dos tipos de "variables" el primero es el val el cual crea
        //un valor que no se puede modificar val = 6
        //Y luego estaría var la cual es una variable normal como en java
        //kotlin tiene autotipado (no hay tipos de variables, un var puede ser cualquier tipo de variable)

        //el comando createRefs() permite crear varias variables a la vez
        //en caso de que fuera createRef() (sin s) solamente permitiría crear una variable
        val(boxRed,boxYellow,boxGreen) = createRefs()
        Box(modifier=Modifier
            .height(400.dp)
            .background(Color.Red)
            .fillMaxWidth()
            //el comando constrainAs le dice al box que tome como referencia la variable boxRed que
            //hemos creado con el comando createRefs
            .constrainAs(boxRed){
                //El parent se refiere a la pantalla principal
                //Los comandos estos nos permiten poner la constraint
                //y su contenido en la posición que queramos haciendo
                //referencia o bien al padre o a otro constraint que esté
                //asociado a algo (por ejemplo, este constraint está asociado a este box)
                start.linkTo(parent.start)
                top.linkTo(boxGreen.bottom)
            }){}

        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .constrainAs(boxYellow){
                //boxRed se refiere a la variable que hemos creado
                //antes la cual está asociada al box anterior a este
                top.linkTo(boxRed.bottom)
                end.linkTo(parent.end)
            })

        Box(modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(Color.Green)
            .constrainAs(boxGreen){
                top.linkTo(parent.top)
            })
    }
}