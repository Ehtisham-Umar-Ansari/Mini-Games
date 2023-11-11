package com.example.eadevelops.minigames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.widget.ImageView
import com.example.eadevelops.minigames.databinding.ActivityGame1Binding
import kotlin.random.Random

class Game1 : AppCompatActivity(){

    private lateinit var binding: ActivityGame1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGame1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.arrow.setOnClickListener(){
           spin()
        }
    }

    private fun spin(){
        val random = (500..5000).random()
        val randomDuration = (1000..5000).random()
        binding.arrow.animate().rotation(random.toFloat()).setDuration(randomDuration.toLong()).start()
    }
}