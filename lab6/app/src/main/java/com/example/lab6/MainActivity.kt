
package com.example.lab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab6.ui.theme.Lab6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab6Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Lab6()
                }
            }
        }
    }
}

@Composable
fun Lab6(
    modifier: Modifier = Modifier
) {
    var counter by remember { mutableStateOf(0) }
    var incrementCount by remember { mutableStateOf(0) }
    var decrementCount by remember { mutableStateOf(0) }
    var maxValue by remember { mutableStateOf(0) }
    var minValue by remember { mutableStateOf(0) }
    var totalChanges by remember { mutableStateOf(0) }
    val history = remember { mutableStateListOf<Pair<Int, Boolean>>() }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Eliazar Canastuj",
            fontSize = 35.sp,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(color = Color.Blue, shape = CircleShape)
                    .clickable(onClick = {
                        counter--
                        decrementCount++
                        totalChanges++
                        if (counter < minValue) minValue = counter
                        history.add(counter to false)
                    }),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.width(25.dp))

            Text(
                text = "$counter",
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
            )

            Spacer(modifier = Modifier.width(25.dp))

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(color = Color.Blue, shape = CircleShape)
                    .clickable(onClick = {
                        counter++
                        incrementCount++
                        totalChanges++
                        if (counter > maxValue) maxValue = counter
                        history.add(counter to true)
                    }),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = null,
                    tint = Color.White
                )
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        // Sección de estadísticas
        StatisticsSection(
            incrementCount = incrementCount,
            decrementCount = decrementCount,
            maxValue = maxValue,
            minValue = minValue,
            totalChanges = totalChanges
        )

        // Sección de historial
        HistorySection(history = history)

        Spacer(modifier = Modifier.weight(1f))


        // Botón de reinicio
        Button(onClick = {
            counter = 0
            incrementCount = 0
            decrementCount = 0
            maxValue = 0
            minValue = 0
            totalChanges = 0
            history.clear()
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Reiniciar")
        }

    }
}

@Composable
fun StatisticsSection(
    incrementCount: Int,
    decrementCount: Int,
    maxValue: Int,
    minValue: Int,
    totalChanges: Int
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        StatisticItem(label = "Total incrementos:", value = incrementCount.toString())
        StatisticItem(label = "Total decrementos:", value = decrementCount.toString())
        StatisticItem(label = "Valor máximo:", value = maxValue.toString())
        StatisticItem(label = "Valor mínimo:", value = minValue.toString())
        StatisticItem(label = "Total cambios:", value = totalChanges.toString())
    }
}

@Composable
fun StatisticItem(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = value,
            fontSize = 20.sp,
        )
    }
}


@Composable
fun HistorySection(history: List<Pair<Int, Boolean>>) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Historial:", fontWeight = FontWeight.Bold, fontSize = 26.sp)

        LazyVerticalGrid(
            columns = GridCells.Fixed(5),  // Máximo 5 columnas
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            items(history) { item ->
                val backgroundColor = if (item.second) Color.Green else Color.Red
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(50.dp)
                        .background(backgroundColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "${item.first}", color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab6Theme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Lab6()
        }
    }
}