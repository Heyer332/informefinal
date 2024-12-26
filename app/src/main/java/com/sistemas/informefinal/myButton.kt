package com.sistemas.informefinal

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.map

@Preview
@Composable
fun myButton(){
    Button(
        onClick = {  },
        modifier = Modifier
            .width(200.dp)
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Magenta,
            contentColor = Color.Black
        )
    ) {
        Text(text = "Haga click aqui")
    }
}

@Preview
@Composable
fun ButtonWithShapeAndSizePreview() {
    Button(
        onClick = { /* Acción básica */ },
        modifier = Modifier
            .width(150.dp)
            .height(50.dp), // Tamaño personalizado
        shape = CutCornerShape(14.dp) // Esquinas cortadas
    ) {
        Text(text = "Haga click aqui")
    }
}

@Preview
@Composable
fun ButtonWithShape() {
    Button(
        onClick = {  },
        shape = RoundedCornerShape(10.dp) // Esquinas redondeadas
    ) {
        Text(text = "Rounded ")
    }
}

@Preview
@Composable
fun ButtonWithElevation() {
    Button(
        onClick = {  },
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp, // Elevación en estado normal
            pressedElevation = 16.dp, // Elevación al presionar
            disabledElevation = 0.dp // Elevación cuando está deshabilitado
        )
    ) {
        Text(text = "Custom Elevation")
    }
}

@Preview
@Composable
fun ButtonWithElevationAndColorsPreview() {
    Button(
        onClick = { /* Acción básica */ },
        modifier = Modifier
            .width(200.dp)
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Cyan,
            contentColor = Color.Black
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 20.dp
        )
    ) {
        Text(text = "Elevation & Colors")
    }
}
@Preview
@Composable
fun ButtonWithBorderPreview() {
    Button(
        onClick = { /* Acción básica */ },
        border = BorderStroke(2.dp, Color.Red) // Grosor y color del borde
    ) {
        Text(text = "Button with Border")
    }
}


@Preview
@Composable
fun ButtonWithBorderAndShapePreview() {
    Button(
        onClick = { /* Acción básica */ },
        shape = RoundedCornerShape(16.dp), // Forma personalizada
        border = BorderStroke(3.dp, Color.Blue), // Grosor y color del borde
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White, // Fondo blanco
            contentColor = Color.Black // Texto negro
        )
    ) {
        Text(text = "Border & Shape")
    }
}


@Preview
@Composable
fun ButtonWithCustomPadding() {
    Button(
        onClick = { /* Acción básica */ },
        contentPadding = PaddingValues(
            start = 16.dp,
            top = 8.dp,
            end = 16.dp,
            bottom = 8.dp
        ) // Ajuste personalizado del relleno
    ) {
        Text(text = "Custom Padding")
    }
}


@Preview
@Composable
fun ButtonWithPaddingAndStylePreview() {
    Button(
        onClick = { /* Acción básica */ },
        modifier = Modifier
            .width(180.dp)
            .height(50.dp),
        shape = RoundedCornerShape(12.dp), // Forma redondeada
        border = BorderStroke(2.dp, Color.Green), // Borde verde
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Yellow, // Fondo amarillo
            contentColor = Color.Black // Texto negro
        ),
        contentPadding = PaddingValues(
            start = 24.dp,
            top = 16.dp,
            end = 24.dp,
            bottom = 16.dp
        ) // Más espacio interno
    ) {
        Text(text = "Styled Button")
    }
}


@Preview
@Composable
fun ButtonWithInteractionSourcePreview() {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = remember(interactionSource) {
        // Detectamos si es una interacción de presión
        interactionSource.interactions.map { interaction ->
            interaction is PressInteraction.Press
        }
    }.collectAsState(initial = false).value

    Button(
        onClick = { /* Acción básica */ },
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(
            // Cambia de color si está presionado
            containerColor = if (isPressed) Color.Red else Color.Blue,
            contentColor = Color.White
        )
    ) {
        Text(text = if (isPressed) "Pressed" else "Not Pressed")
    }
}


@Preview
@Composable
fun FullyCustomButtonPreview() {
    // Fuente de interacción para rastrear eventos
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = remember(interactionSource) {
        interactionSource.interactions.map { it is PressInteraction.Press }
    }.collectAsState(initial = false).value

    // Animación para cambiar colores según el estado
    val animatedColor = animateColorAsState(
        targetValue = if (isPressed) Color.Green else Color.Cyan
    )

    Button(
        onClick = { /* Acción personalizada */ },
        modifier = Modifier
            .width(200.dp)
            .height(60.dp) // Ajuste del tamaño del botón
            .padding(8.dp), // Espaciado externo
        shape = RoundedCornerShape(12.dp), // Esquinas redondeadas
        border = BorderStroke(2.dp, Color.Magenta), // Borde personalizado
        colors = ButtonDefaults.buttonColors(
            containerColor = animatedColor.value, // Fondo animado
            contentColor = Color.Black
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp, // Elevación normal
            pressedElevation = 20.dp // Elevación al presionar
        ),
        contentPadding = PaddingValues(
            start = 16.dp,
            top = 12.dp,
            end = 16.dp,
            bottom = 12.dp
        ), // Relleno interno personalizado
        interactionSource = interactionSource // Fuente de interacciones
    ) {
        // Contenido del botón: ícono y texto
        Icon(
            imageVector = Icons.Default.ThumbUp, // Ícono
            contentDescription = "Like Icon",
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
        // Espacio entre ícono y texto
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Like") // Texto del botón
    }
}
