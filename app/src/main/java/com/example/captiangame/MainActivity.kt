package com.example.captiangame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.captiangame.ui.theme.CaptianGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptianGameTheme {
                val viewModel : CaptainViewModel = viewModel()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame(viewModel)
                }
            }
        }
    }
}

@Composable
fun CaptainGame(viewModel: CaptainViewModel) {
    //remember : keeps the track of datacollected
    //mutablestateOf : state that can be changed.

  /*  val tresureHunt = remember { mutableStateOf(0) }
    val direction = remember { mutableStateOf(" ") }
    val stormOrTreasure = remember { mutableStateOf(" ") }*/

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text("Direction of the ship : ${viewModel.direction.value}",
            style = TextStyle(fontSize = 20.sp ,))//we have to use .value to access the data.

        Spacer(modifier = Modifier.height(16.dp))

        Text("Treasure hunter : ${viewModel.treasureHunt.value}",
            style = TextStyle(fontSize = 20.sp))

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Storm : or Treasure: ${viewModel.stormOrTreasure.value}",
            style = TextStyle(fontSize = 20.sp))

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                viewModel.direction("East")
                //Random.nextBoolean gives a random boolean if true inside if otherwise in else
            }) {
                Text(text = "EAST")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                viewModel.direction("West")
            }) {
                Text(text = "WEST")
            }

        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Button(onClick = {
                viewModel.direction("North")
            }) {
                Text(text = "North")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                viewModel.direction("South")
            }) {
                Text(text = "SOUTH")
            }
        }
    }
}