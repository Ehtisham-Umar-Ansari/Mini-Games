package com.example.eadevelops.minigames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eadevelops.minigames.databinding.ActivityGame3Binding

class Game3 : AppCompatActivity() {

    private lateinit var binding : ActivityGame3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityGame3Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.dice.setOnClickListener(){
            binding.dice.animate().rotation(binding.dice.rotation + 720).setDuration(600).start()
            spin()
        }
    }

    private fun spin() {

        when((1..6).random()){
            1-> binding.dice.setImageResource(R.drawable.dice1)
            2-> binding.dice.setImageResource(R.drawable.dice2)
            3-> binding.dice.setImageResource(R.drawable.dice3)
            4-> binding.dice.setImageResource(R.drawable.dice4)
            5-> binding.dice.setImageResource(R.drawable.dice5)
            6-> binding.dice.setImageResource(R.drawable.dice6)
        }
        return
    }
}