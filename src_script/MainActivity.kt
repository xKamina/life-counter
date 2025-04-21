package com.example.mtglifecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LifeCounterScreen()
            BottomSheetMenu()
                }
            }
        }

@Composable
fun LifeCounterScreen() {
    var lives1Player by remember { mutableIntStateOf(20) } //Valor inicial de 30 vidas
    var lives2Player by remember { mutableIntStateOf(20) }


    Column(modifier = Modifier.fillMaxSize())//Dividir la pantalla en dos, linea horizontal
    {
        //Parte superior
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color(0xFFFFA500)),
            contentAlignment = Alignment.Center
        )
        {
            //Contador de vidas
            Text(
                text = "$lives1Player",
                fontSize = with(LocalDensity.current) { 80.dp.toSp() },
                color = Color.Black
            )

            //Botones
            Row(horizontalArrangement = Arrangement.Center)
            {
                //Bajar 10 vidas
                Button(
                    onClick = { lives1Player -= 10 },
                    border = BorderStroke(2.dp, Color.Black),
                    shape = CircleShape,
                    modifier = Modifier.size(45.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                    contentPadding = PaddingValues(0.dp)
                )
                {
                    Text(text = "-10", fontSize = 14.sp, color = Color.Black)
                }
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))

                //Bajar 1 vida
                Button(
                    onClick = { lives1Player --},
                    border = BorderStroke(2.dp, Color.Black),
                    shape = CircleShape,
                    modifier = Modifier.size(55.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                    contentPadding = PaddingValues(0.dp)
                )
                {
                    Text(text = "-", fontSize = 20.sp, color = Color.Black)
                }
                Spacer(modifier = Modifier.padding(horizontal = 60.dp))

                Row(horizontalArrangement = Arrangement.Center)
                {
                    //Subir 1 vidas
                    Button(
                        onClick = { lives1Player ++},
                        border = BorderStroke(2.dp, Color.Black),
                        shape = CircleShape,
                        modifier = Modifier.size(55.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                        contentPadding = PaddingValues(0.dp)
                    )
                    {
                        Text(text = "+", fontSize = 20.sp, color = Color.Black)
                    }
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))

                    //Subir 10 vidas
                    Button(
                        onClick = { lives1Player += 10 },
                        border = BorderStroke(2.dp, Color.Black),
                        shape = CircleShape,
                        modifier = Modifier.size(45.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                        contentPadding = PaddingValues(0.dp)
                    )
                    {
                        Text(text = "+10", fontSize = 14.sp, color = Color.Black)
                    }
                }
            }
        }

        //Parte inferior
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color(0xFF00CED1)),
            contentAlignment = Alignment.Center
        )
        {
            //Contador de vidas
            Text(
                text = "$lives2Player",
                fontSize = with(LocalDensity.current) { 80.dp.toSp() },
                color = Color.Black
            )

            //Botones
            Row(horizontalArrangement = Arrangement.Center)
            {
                //Bajar 10 vidas
                Button(
                    onClick = { lives2Player -= 10 },
                    border = BorderStroke(2.dp, Color.Black),
                    shape = CircleShape,
                    modifier = Modifier.size(45.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                    contentPadding = PaddingValues(0.dp)
                )
                {
                    Text(text = "-10", fontSize = 14.sp, color = Color.Black)
                }
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))

                //Bajar 1 vida
                Button(
                    onClick = { lives2Player -= 1 },
                    border = BorderStroke(2.dp, Color.Black),
                    shape = CircleShape,
                    modifier = Modifier.size(55.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                    contentPadding = PaddingValues(0.dp)
                )
                {
                    Text(text = "-", fontSize = 20.sp, color = Color.Black)
                }
                Spacer(modifier = Modifier.padding(horizontal = 60.dp))

                Row(horizontalArrangement = Arrangement.Center)
                {
                    //Subir 1 vidas
                    Button(
                        onClick = { lives2Player += 1 },
                        border = BorderStroke(2.dp, Color.Black),
                        shape = CircleShape,
                        modifier = Modifier.size(55.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                        contentPadding = PaddingValues(0.dp)
                    )
                    {
                        Text(text = "+", fontSize = 20.sp, color = Color.Black)
                    }
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))

                    //Subir 10 vidas
                    Button(
                        onClick = { lives2Player += 10 },
                        border = BorderStroke(2.dp, Color.Black),
                        shape = CircleShape,
                        modifier = Modifier.size(45.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                        contentPadding = PaddingValues(0.dp)
                    )
                    {
                        Text(text = "+10", fontSize = 14.sp, color = Color.Black)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetMenu() {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { isSheetOpen = true },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(8.dp)
        ) {
            Text(text = "Menú")
        }
    }

    if(isSheetOpen){
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isSheetOpen = false}){}

    }
}