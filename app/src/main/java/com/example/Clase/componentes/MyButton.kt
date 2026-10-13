package com.example.Clase.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.SegmentedButtonDefaults.borderStroke
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable

fun MyButton(modifier: Modifier = Modifier){

    Column(modifier = modifier.safeDrawingPadding()) {
       //Crea la función MyButton1
        MyButton1()

    }
}

@Composable
fun MyButton1() {
    //rememberSaveable significa que cuando giras el movil, sus componentes que tu has creado
    //mantienen sus valores iniciales. Pero con remember no se mantienen. Por ejemplo si hago click
    //en el botón se desactivará, y si le doy la vuelta al movil y hago uso de saveable entonces seguirá estando desactivado pero con remember estará activado
    var enable by rememberSaveable() { mutableStateOf(true) }
    //Crea un boton
    Button(
        //Cuando lo pulsas muestra por consola el texto pulsado. El tag se refiere a que función hace
        //referencia, en este caso es MyButton
        //onClick = {Log.d("MyButton","pulsado")},

        //cuando le hagamos click al botón este se deshabilitará. para ello hemos hecho
        //una variable llamada enable la cual hemos hecho que sea mutableStateOf(true), eso
        //significa que cuando cambie el estado de algo, ese algo cuando se deshabilite se redibuje
        //y de esa manera pueda deshabilitarse correctamente. Ya que en kotlin para deshabilitar algo/cambiar de estado algo
        //necesitamos redibujarlo.
        onClick = {enable=false},
            enabled = enable,
            //Comando para cambiar el color del botón
            colors = ButtonDefaults.buttonColors(
                //containerColor se refiere al color de fondo del color
                    containerColor = Color.Red,
                    //contentColor se refiere al color que tendrá su contenido como el texto
                    contentColor = Color.Blue,
                    //cuando algo está disabled usará estos colores
                    disabledContainerColor = Color.Green,
                    disabledContentColor = Color.Cyan
            ),
            border = borderStroke(Color.Yellow, width = 3.dp),
        //shape es para darle la forma que queremos. En este caso podemos modificar
        //los bordes del botón para que sean más redondos con RoundedCornerShape
        shape = RoundedCornerShape(120.dp)
        ) {
        Text("Pulsar")
    }
}