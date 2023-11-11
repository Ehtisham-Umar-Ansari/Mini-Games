package com.example.eadevelops.minigames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eadevelops.minigames.databinding.ActivityGame4Binding

class Game4 : AppCompatActivity() {

    private lateinit var binding: ActivityGame4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGame4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toss.setOnClickListener(){
            binding.toss.animate().rotationX(binding.toss.rotationX + 720).setDuration(1000).start()
            binding.toss.animate().rotationY(binding.toss.rotationY + 720).setDuration(1000).start()
            call()
        }
    }

    private fun call() {
        val random = (1..50).random()
        val conclusion : Boolean = random%2  == 0

        if(conclusion){
            binding.toss.setImageResource(R.drawable.coin)
            binding.result.text = "Heads"
        }else{
            binding.toss.setImageResource(R.drawable.rupee)
            binding.result.text = "Tails"
        }
    }
}