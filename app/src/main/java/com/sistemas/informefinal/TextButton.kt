package com.sistemas.informefinal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun BasicButton() {
    TextButton(onClick = {
    }) {
        Text("Presiona aquí")
    }
}

@Preview
@Composable
fun CustomizedText() {
    TextButton(onClick = {  }) {
        Text(
            text = "Botón personalizado",
            color = Color.Blue,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun DisabledButton() {
    TextButton(
        onClick = { /* Acción */ },
        enabled = false
    ) {
        Text("Botón deshabilitado")
    }
}

@Preview
@Composable
fun CustomizedColors() {
    TextButton(
        onClick = { /* Acción */ },
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color.Green,
            disabledContentColor = Color.Gray
        )
    ) {
        Text("Botón con colores personalizados")
    }
}

@Preview
@Composable
fun ShapeAndSize() {
    TextButton(
        onClick = { /* Acción */ },
        modifier = Modifier
            .padding(8.dp)
            .size(200.dp, 50.dp)
    ) {
        Text("Botón personalizado")
    }
}

@Preview
@Composable
fun IconButton() {
    TextButton(onClick = {  }) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Icono"
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("Me encocora")
    }
}

@Preview
@Composable
fun FullTextButton() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextButton(
            onClick = { /* Acción combinada */ },
            enabled = true,
            modifier = Modifier,
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Green,
                disabledContentColor = Color.Gray
            ),
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 10.dp,
                end = 20.dp,
                bottom = 10.dp
            ),
        ) {
            Text("TextButton Completo")
        }
    }
}
