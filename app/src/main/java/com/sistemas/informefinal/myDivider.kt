package com.sistemas.informefinal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable

fun myDivider() {

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Texto encima del divisor")
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Gray
        )
        Text(text = "Texto debajo del divisor",
            color = Color.White)
    }
}

@Preview
@Composable
fun BasicVerticalDividerExample() {
    Row(modifier = Modifier.padding(16.dp)) {
        Text(text = "Texto a la izquierda")
        VerticalDivider(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 8.dp),
            thickness = 1.dp,
            color = Color.White
        )
        Text(text = "Texto a la derecha")
    }
}

@Preview
@Composable
fun ThickCustomDividerExample() {
    Column {
        HorizontalDivider(
            thickness = 4.dp, // Grosor del divisor
            color = Color.Blue // Color personalizado
        )
        HorizontalDivider(
            thickness = 8.dp, // Grosor más grueso
            color = Color.Green
        )
    }
}
@Preview
@Composable
fun CombinedDividersExample() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Texto 1")
        HorizontalDivider(color = Color.Red, thickness = 2.dp)
        Row {
            Text(text = "Izquierda")
            VerticalDivider(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 8.dp),
                color = Color.Blue,
                thickness = 2.dp
            )
            Text(text = "Derecha")
        }
        HorizontalDivider(color = Color.Green, thickness = 4.dp)
        Text(text = "Texto 2")
    }
}