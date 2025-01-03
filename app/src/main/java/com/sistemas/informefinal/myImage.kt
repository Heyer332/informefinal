package com.sistemas.informefinal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home

import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds

import androidx.compose.ui.graphics.ColorFilter

import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Preview
@Composable
fun BasicImagePreview() {
    Image(
        painter = rememberVectorPainter(Icons.Default.Favorite), // Imagen vectorial
        contentDescription = "Favorite Icon"
    )
}

@Preview
@Composable
fun LocalImagePreview() {
    Image(
        // Nombre de la imagen en drawable
        painter = painterResource(id = R.drawable.imagen),
        contentDescription = "Imagen local de ejemplo",
        // Tamaño personalizado
        modifier = Modifier.size(200.dp)
    )
}

@Preview
@Composable
fun ImageWithContentScalePreview() {
    Image(
        painter = rememberVectorPainter(Icons.Default.ThumbUp),
        contentDescription = "Thumb Up Icon",
        modifier = Modifier.size(150.dp),
        // Ajuste para recortar la imagen
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ImageWithAlphaPreview() {
    Image(
        painter = rememberVectorPainter(Icons.Default.Home),
        contentDescription = "Home Icon",
        modifier = Modifier.size(100.dp),
        alpha = 0.5f // Imagen semitransparente
    )
}

@Preview
@Composable
fun ImageWithColorFilterPreview() {
    Image(
        painter = rememberVectorPainter(Icons.Default.Email),
        contentDescription = "Email Icon",
        modifier = Modifier.size(100.dp),
        // Cambia el color del ícono a rojo
        colorFilter = ColorFilter.tint(androidx.compose.ui.graphics.Color.Red)
    )
}

@Preview
@Composable
fun FullyCustomImagePreview() {
    Image(
        painter = rememberVectorPainter(Icons.Default.Favorite),
        contentDescription = "Favorite Icon",
        modifier = Modifier
            .size(150.dp) // Tamaño personalizado
            .padding(16.dp) // Relleno externo
            .clipToBounds(), // Recorte al tamaño definido
        // Alineado en la esquina superior derecha
        alignment = Alignment.TopEnd,
        // Escala para que la imagen encaje en el contenedor
        contentScale = ContentScale.Fit,
        alpha = 0.8f, // Opacidad ajustada
        // Filtro de color magenta
        colorFilter = ColorFilter.tint(androidx.compose.ui.graphics.Color.Cyan),

    )
}

@Preview
@Composable
fun FullyCustomImageFromNetworkPreview() {
    AsyncImage(
        model = "https://via.placeholder.com/150", // URL de la imagen
        contentDescription = "Imagen de ejemplo desde red",
        modifier = Modifier
            .size(200.dp) // Tamaño fijo
            .padding(16.dp) // Espaciado externo
            .clipToBounds(), // Recorte al tamaño definido
        alignment = Alignment.Center, // Alineación centrada
        contentScale = ContentScale.Crop, // Recorte para llenar el contenedor
        alpha = 0.9f, // Opacidad casi completa
        // Filtro para aplicar un tono gris
        colorFilter = ColorFilter.tint(androidx.compose.ui.graphics.Color.Blue)
    )
}
