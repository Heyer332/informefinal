package com.sistemas.informefinal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun FullTextButtonWithCircularImages() {
    TextButton(
        onClick = { /* Acción completa */ },
        enabled = true,
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color.Green
        ),
        contentPadding = ButtonDefaults.TextButtonContentPadding
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.imagen),
                contentDescription = "Imagen 1",
                modifier = Modifier.size(40.dp),
                contentScale = ContentScale.Crop
            )
            Text("Texto con imágenes")
            Image(
                painter = painterResource(id = R.drawable.imagen),
                contentDescription = "Imagen 2",
                modifier = Modifier.size(40.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}
