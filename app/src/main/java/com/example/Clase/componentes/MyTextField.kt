package com.example.Clase.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.tooling.preview.Preview

@Preview
// @Composable = Esta función sabe dibujar en pantalla. Sin esto es una función normal de Kotlin.
@Composable
// MyTextField es tu pantalla principal. Recibe un Modifier opcional para poder moverla/cambiarla desde fuera.
fun MyTextField(modifier: Modifier = Modifier){

    // ESTO ES EL ESTADO. Es la parte más importante de Compose.
    // mutableStateOf("") -> Creo una caja que guarda un String vacío.
    // Cuando el valor de la caja cambia, Compose redibuja la pantalla automáticamente.
    // rememberSaveable -> Que no se borre/cambie su contenido si giras el móvil o minimizas la app.
    // by -> Truco de Kotlin. Te deja usar `user` directamente en vez de `user.value`.
    // var -> tipo de variable que puede adoptar cualquier valor. la usamos porque su contenido va a cambiar
    var user by rememberSaveable { mutableStateOf("") }
    var dato by rememberSaveable { mutableStateOf("") }
    var dato2 by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    // Column -> Pone todo lo que hay dentro UNO DEBAJO DE OTRO, en vertical.
    Column(modifier = modifier) {

        // Row -> Pone todo lo que hay dentro UNO AL LADO DE OTRO, en horizontal.
        // verticalAlignment = Alignment.CenterVertically -> Centra los elementos verticalmente dentro de la fila.
        Row(verticalAlignment = Alignment.CenterVertically) {

            // Text -> Un texto simple en pantalla.
            // Modifier.padding(end = 5.dp) -> Le añade 5dp de separación a la derecha. dp = unidad de medida de Android.
            Text("Usuario", modifier = Modifier.padding(end = 5.dp))

            // Llamas a tu propia función. Le pasas el valor actual `user` y una función lambda.
            // { user = it } -> `it` es lo que el usuario acaba de escribir. Se lo guardas a tu variable `user`.
            MyTextFieldUser(user) { user = it }
        }

        // Muestra en pantalla lo que has escrito en user. Si user cambia, este Text cambia solo.
        Text(user)

        // Otros campos. Misma idea: le paso el dato y como tiene que guardarlo.
        TextFieldDato(dato) { dato = it }
        PasswordTextField(password) { password = it }
        TextFieldChange(dato2) { dato2 = it }
    }
}

// --- COMPONENTE 1: EL MÁS SIMPLE ---

@Composable
// Esta función NO guarda nada. Solo dibuja.
// user: String -> El texto que tiene que mostrar.
// onUserChange: (String) -> Unit -> Una función que recibe un String y no devuelve nada. Es el "aviso".
// Significa: "Yo no guardo el dato, cuando el usuario escriba, llamo a esta función para avisar a mi padre"
fun MyTextFieldUser(user: String, onUserChange: (String) -> Unit){
    // TextField es el campo de texto clásico de Material Design.
    // value -> lo que muestra.
    // onValueChange -> se ejecuta cada vez que tecleas. `it` es el texto nuevo.
    TextField(value = user, onValueChange = { onUserChange(it) })
}

// --- COMPONENTE 2: CON PLACEHOLDER PERSONALIZADO ---

@Composable
fun TextFieldDato(dato: String, onValueChange: (String) -> Unit){
    TextField(
        value = dato,
        onValueChange = { onValueChange(it) },
        // placeholder -> Lo que se ve cuando el campo está vacío.
        // Aquí no pones un Text normal, pones tu propia función MyBoxWithText().
        placeholder = { MyBoxWithText() }
    )
}

@Composable
fun MyBoxWithText(){
    // Box -> Una caja para apilar cosas una encima de otra. Como un Frame.
    // Modifier.size(100.dp) -> La caja mide 100x100.
    // .background(Color.Red) -> Fondo rojo. El orden del Modifier importa.
    Box(modifier = Modifier.size(100.dp).background(Color.Red)){
        Text("Introducir dato")
    }
}

// --- COMPONENTE 3: CONTRASEÑA CON OJO PARA VER/OCULTAR ---

@Composable
fun PasswordTextField(
    password: String,
    onValueChange: (String) -> Unit
){
    // Estado LOCAL, solo para este componente. No necesita subir al padre.
    // Guarda si la contraseña se tiene que ver o no. Empieza en false (oculta).
    var visible by rememberSaveable { mutableStateOf(false) }

    // OutlinedTextField -> Igual que TextField pero con borde. Es más moderno.
    OutlinedTextField(
        value = password,
        onValueChange = { onValueChange(it) },
        singleLine = true, // Prohibe que se haga multilinea con Enter.
        label = { Text("Password") }, // El texto que está dentro y sube arriba cuando escribes.

        // keyboardOptions -> Le dices al teclado cómo debe comportarse.
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password // Teclado para contraseñas
        ),

        // visualTransformation -> Cómo se dibuja el texto.
        // if(visible) -> Si es visible, no hagas nada (None).
        // else -> Si no, pon puntitos negros (PasswordVisualTransformation)
        visualTransformation = if(visible){
            VisualTransformation.None
        }else{
            PasswordVisualTransformation()
        },

        // trailingIcon -> Un icono al final del campo, a la derecha.
        trailingIcon = {
            // Si visible es true, usa el icono del ojo abierto. Si no, ojo cerrado.
            val image = if(visible){
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            val descripcion = if (visible) "Ocultar" else "Mostrar"

            // IconButton -> Un botón que es un icono.
            // onClick = { visible = !visible } -> Cada click invierte el valor: de true a false y al revés.
            IconButton(onClick = { visible = !visible }){
                // Icon -> Dibuja el icono.
                // contentDescription -> Texto para personas ciegas que usan lector de pantalla. Es obligatorio.
                Icon(imageVector = image, contentDescription = descripcion)
            }
        }
    )
}

// --- COMPONENTE 4: CAMPO CON FILTRO / LÓGICA ---

@Composable
fun TextFieldChange(
    dato: String,
    onValueChange: (String) -> Unit
){
    TextField(
        value = dato,
        onValueChange={
            // `it` es el texto nuevo que acaba de escribir el usuario.

            // it.contains("a") -> ¿El texto contiene una "a"? Devuelve true/false.
            if(it.contains("a")){
                // it.replace("a","B") -> Crea un texto nuevo cambiando todas las "a" por "B".
                // Ejemplo: si escribes "hola" -> se guarda "holB"
                onValueChange(it.replace("a","B"))
            }else{
                // Si no hay "a", guarda el texto tal cual.
                onValueChange(it)
            }
        }
    )
}