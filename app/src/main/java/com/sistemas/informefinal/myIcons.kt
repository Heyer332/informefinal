package com.sistemas.informefinal

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable

fun myIcons(){
    Icon(
        modifier = Modifier
            .size(48.dp),//Tamaño
        imageVector = Icons.Default.DateRange, // Ícono predeterminado
        contentDescription = "Calendario",
        tint = Color.Magenta
    )
}


@Preview
@Composable
fun IconWithPainterPreview() {
    val painter = rememberVectorPainter(Icons.Default.Settings)
    Icon(
        painter = painter,
        contentDescription = "Settings Icon",
        modifier = Modifier.size(56.dp),
        tint = Color.Green // Aplicar un tinte verde
    )
}

@Preview
@Composable
fun FullyCustomIconPreview() {
    Icon(
        imageVector = Icons.Default.Notifications, // Ícono vectorial
        contentDescription = "Notifications Icon",
        modifier = Modifier
            .size(72.dp) // Tamaño grande
            .padding(8.dp), // Espaciado externo
        tint = Color.Black // Tinte magenta
    )
}
