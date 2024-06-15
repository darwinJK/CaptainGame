package com.example.captiangame

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random


class CaptainViewModel : ViewModel(){
    var direction = mutableStateOf("")
        private set
    var treasureHunt = mutableStateOf(0)
        private set
    var stormOrTreasure = mutableStateOf("")
        private set

    fun direction(value :String){
        direction.value = value
        if (Random.nextBoolean()) {
            treasureHunt.value += 1
            stormOrTreasure.value = "treasure found"
        } else {
            stormOrTreasure.value = "storm"
        }
    }

}