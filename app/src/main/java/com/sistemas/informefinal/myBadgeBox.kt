package com.sistemas.informefinal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*

@Preview
@Composable
fun BasicBadgeBox() {
    var notificationCount by remember { mutableStateOf(5) }

    BadgedBox(
        modifier = Modifier.padding(16.dp),
        badge = {
            if (notificationCount > 0) {
                Badge {
                    Text(text = notificationCount.toString())
                }
            }
        },
        content = {
            IconButton(onClick = {  }) {
                Icon(imageVector = Icons.Default.Notifications,
                    contentDescription = "Notificaciones")
            }
        }
    )
}
@Preview
@Composable
fun CustomizedBadgeBox() {
    var notificationCount by remember { mutableStateOf(10) }

    BadgedBox(
        modifier = Modifier.padding(16.dp),
        badge = {
            if (notificationCount > 0) {
                Badge(
                    modifier = Modifier
                        .background(Color.Red, shape = CircleShape)
                        .padding(8.dp),
                    contentColor = Color.White
                ) {
                    Text(text = notificationCount.toString())
                }
            }
        },
        content = {
            IconButton(onClick = {  }) {
                Icon(imageVector = Icons.Default.Notifications,
                    contentDescription = "Notificaciones")
            }
        }
    )
}
@Preview
@Composable
fun ListWithBadges() {
    val items = listOf("Elemento 1", "Elemento 2", "Elemento 3")
    val notifications = listOf(3, 0, 1)  // Cantidad de notificaciones para cada elemento

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        itemsIndexed(items) { index, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = item)
                if (notifications[index] > 0) {
                    Badge {
                        Text(text = notifications[index].toString())
                    }
                }
            }
        }
    }
}
@Preview
@Composable
fun BadgeWithText() {
    var count by remember { mutableStateOf(10) }

    BadgedBox(
        modifier = Modifier.padding(16.dp),
        badge = {
            if (count > 0) {
                Badge {
                    Text(text = count.toString())
                }
            }
        },
        content = {
            Button(onClick = {  }) {
                Text(text = "Mis Notificaciones")
            }
        }
    )
}


