package com.example.lab5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5.ui.theme.Lab5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Agosto5()
                }
            }
        }
    }
}


@Composable
fun Agosto5(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE0F7FA))
        ) {
            Icon(
                Icons.Default.Refresh,
                contentDescription = "Actualizar",
                modifier = Modifier
                    .size(24.dp)
                    .weight(0.2f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Actualización disponible",
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier.weight(0.5f)
            )
            Text(
                text = "Descargar",
                color = Color(0xFF0288D1),
                modifier = Modifier
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp"))
                        context.startActivity(intent)
                    }
                    .weight(0.5f),
                textAlign = TextAlign.End
            )

        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = "Jueves",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "7 de noviembre",
                    fontSize = 20.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { /* Acción para terminar la jornada */ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier
                    .border(1.dp, Color.Gray, RoundedCornerShape(10.dp))
            ) {
                Text(
                    text = "Terminar jornada",
                    fontSize = 12.sp,
                    color = Color(0xFF800080)
                )
            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Vesuvio",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = "Directions",
                        modifier = Modifier.clickable {
                            val gmmIntentUri =
                                Uri.parse("geo:0,0?q=14.634915,-90.506882(Vesuvio)")
                            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                            mapIntent.setPackage("com.google.android.apps.maps")
                            context.startActivity(mapIntent)
                        }
                    )
                }

                Text(
                    text = " Paseo Cayalá, Blvr. Rafael Landivar 10-05",
                    color = Color.Gray
                )
                Text(
                    text = "10a.m.–10p.m",
                    color = Color.Gray
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            Toast.makeText(context, "Eliazar Jose Pablo Canastuj Matias", Toast.LENGTH_LONG).show()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6F61)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp),


                    ) {
                        Text("Iniciar")
                    }


                    Button(
                        onClick = {
                            Toast.makeText(context, "\"Tipo de comida: Pizza\\n¿Qué tan caro es? Caro: QQQ\"", Toast.LENGTH_LONG).show()
                        },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(
                            text = "Detalles",
                            color = Color(0xFFFF6F61),
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewLab() {
    Lab5Theme() {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Agosto5()
        }
    }
}