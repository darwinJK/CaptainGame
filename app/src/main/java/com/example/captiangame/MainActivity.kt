package com.example.captiangame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.captiangame.ui.theme.CaptianGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptianGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }
}

@Composable
fun CaptainGame() {
    //remember : keeps the track of datacollected
    //mutablestateOf : state that can be changed.

    val tresureHunt = remember { mutableStateOf(0) }
    val direction = remember { mutableStateOf(" ") }
    val stormOrTreasure = remember { mutableStateOf(" ") }

    Column {
        Text("direction of the ship : ${direction.value}")//we have to use .value to access the data.
        Text("treasure hunter : ${tresureHunt.value}")
        Text(text = "storm : or treasure: ${stormOrTreasure.value}")
        Row {
            Button(onClick = {
                if (Random.nextBoolean()) {
                    tresureHunt.value = tresureHunt.value + 1
                    stormOrTreasure.value = "treasure found"
                } else {
                    stormOrTreasure.value = "storm"
                }
                //Random.nextBoolean gives a random boolean if true inside if otherwise in else
            }) {
                Text(text = "EAST")
            }
            Button(onClick = {
                if (Random.nextBoolean()) {
                    tresureHunt.value = tresureHunt.value + 1
                    stormOrTreasure.value = "treasure found"
                } else {
                    stormOrTreasure.value = "storm"
                }
            }) {
                Text(text = "WEST")
            }

        }
        Row {
            Button(onClick = {
                if (Random.nextBoolean()) {
                    tresureHunt.value = tresureHunt.value + 1
                    stormOrTreasure.value = "treasure found"
                } else {
                    stormOrTreasure.value = "storm"
                }
            }) {
                Text(text = "North")
            }
            Button(onClick = {
                if (Random.nextBoolean()) {
                    tresureHunt.value = tresureHunt.value + 1
                    stormOrTreasure.value = "treasure found"
                } else {
                    stormOrTreasure.value = "storm"
                }
            }) {
                Text(text = "SOUTH")
            }
        }
    }
}