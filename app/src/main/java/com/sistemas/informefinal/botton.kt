package com.sistemas.informefinal

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MostrarBotones() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Botón básico
        Button(onClick = { /* Acción básica */ }) {
            Text(text = "Botón Básico")
        }

        // Botón deshabilitado
        Button(
            onClick = { /* Acción deshabilitada */ },
            enabled = false
        ) {
            Text(text = "Deshabilitado")
        }

        // Botón con ícono
        Button(onClick = { /* Acción con ícono */ }) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Ícono Favorito",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Con Ícono")
        }

        // Botón con borde (OutlinedButton)
        OutlinedButton(onClick = { /* Acción */ }) {
            Text(text = "Botón con Borde")
        }

        // Botón de texto (TextButton)
        TextButton(onClick = { /* Acción */ }) {
            Text(text = "Botón de Texto", color = Color.Blue)
        }

        // Colores personalizados
        Button(
            onClick = { /* Acción */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6200EE),
                contentColor = Color.White
            )
        ) {
            Text(text = "Colores Personalizados")
        }

        // Botón redondeado
        Button(
            onClick = { /* Acción */ },
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "Botón Redondeado")
        }

        // Botón con elevación personalizada
        Button(
            onClick = { /* Acción */ },
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 12.dp)
        ) {
            Text(text = "Con Elevación")
        }

        // Botón con padding personalizado
        Button(
            onClick = { /* Acción */ },
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Text(text = "Con Padding Personalizado")
        }
    }
}

// Actividad principal para mostrar los botones

    