package com.example.lab7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab7.ui.theme.Lab7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab7Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NotificationScreen()
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen() {
    val allNotifications = generateFakeNotifications()
    var selectedFilter by remember { mutableStateOf<NotificationType?>(null) }
    val filteredNotifications = selectedFilter?.let { filter ->
        allNotifications.filter { it.type == filter }
    } ?: allNotifications


    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TopAppBar(
            title = {
                Text("Notificaciones")
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            ),
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )

                }

            }
        )


        Text(
            text = "Tipos de notificaciones",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )

        FilterSection(
            selectedFilter = selectedFilter,
            onFilterSelected = { filter ->
                selectedFilter = if (selectedFilter == filter) null else filter
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        NotificationList(notifications = filteredNotifications)
    }
}


@Composable
fun FilterSection(selectedFilter: NotificationType?, onFilterSelected: (NotificationType) -> Unit) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        items(NotificationType.values().size) { index ->
            val filter = NotificationType.values()[index]
            FilterChip(
                selected = selectedFilter == filter,
                onClick = { onFilterSelected(filter) },
                modifier = Modifier.padding(4.dp),
                label = { Text(text = filter.name) },
                leadingIcon = if (selectedFilter == filter) {
                    { Icon(imageVector = Icons.Default.Check, contentDescription = null) }
                } else null,
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = if (selectedFilter == filter) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
                    labelColor = if (selectedFilter == filter) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
                )
            )
        }
    }
}

@Composable
fun NotificationList(notifications: List<Notification>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(notifications) { notification ->
            NotificationItem(notification = notification)
        }
    }
}

@Composable
fun NotificationItem(notification: Notification) {
        val backgroundColor = when (notification.type) {
            NotificationType.Informativas -> MaterialTheme.colorScheme.onPrimary
            NotificationType.Capacitaciones -> MaterialTheme.colorScheme.onSecondary
            NotificationType.Alertas -> MaterialTheme.colorScheme.onTertiary
            NotificationType.Actualizaciones -> MaterialTheme.colorScheme.onError
        }

        val iconColor = when (notification.type) {
            NotificationType.Informativas -> MaterialTheme.colorScheme.primary
            NotificationType.Capacitaciones -> MaterialTheme.colorScheme.secondary
            NotificationType.Alertas -> MaterialTheme.colorScheme.tertiary
            NotificationType.Actualizaciones -> MaterialTheme.colorScheme.error
        }

        val icon: ImageVector = when (notification.type) {
            NotificationType.Informativas -> Icons.Default.KeyboardArrowUp
            NotificationType.Capacitaciones -> Icons.Default.Notifications
            NotificationType.Alertas -> Icons.Default.Add
            NotificationType.Actualizaciones -> Icons.Default.ArrowBack
        }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(iconColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = notification.title, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = notification.content)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "${notification.date} - ${notification.time}")
            }
        }
    }
}







@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab7Theme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            NotificationScreen()
        }
    }
}