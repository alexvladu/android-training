package com.example.captiangame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.captiangame.ui.theme.CaptianGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptianGameTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CapitanGame()
                }
            }
        }
    }
    @Composable
    fun CapitanGame(){
        val treasureFound = remember { mutableStateOf(0) }
        val direction = remember { mutableStateOf("North") }

        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Treasures found: ${treasureFound.value}")
            Text(text = "Current direction: ${direction.value}")

            Row {
                Button(onClick = {
                    direction.value="North"
                    if(Random.nextBoolean()){
                        treasureFound.value+=1
                    }
                }) {
                    Text("Sail North")
                }
            }
            Row {
                Button(onClick = {
                    direction.value="West"
                    if(Random.nextBoolean()){
                        treasureFound.value+=1
                    }
                }) {
                    Text("Sail West")
                }
                Button(onClick = {
                    direction.value="East"
                    if(Random.nextBoolean()){
                        treasureFound.value+=1
                    }
                }) {
                    Text("Sail East")
                }
            }
            Row {
                Button(onClick = {
                    direction.value="South"
                    if(Random.nextBoolean()){
                        treasureFound.value+=1
                    }
                }) {
                    Text("Sail South")
                }
            }
        }
    }

}