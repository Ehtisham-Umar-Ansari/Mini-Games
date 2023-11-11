package com.example.eadevelops.minigames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.eadevelops.minigames.databinding.ActivityAddPlayersBinding

class Add_Players : AppCompatActivity() {

    private lateinit var binding: ActivityAddPlayersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startGameBtn.setOnClickListener(){
            val getPlayer1Name = binding.player1.text.toString()
            val getPlayer2Name = binding.player2.text.toString()

            if (getPlayer1Name.isEmpty() || getPlayer2Name.isEmpty()){
                Toast.makeText(this, "Please enter player name", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, Game2::class.java)
                intent.putExtra("player_one", getPlayer1Name)
                intent.putExtra("player_two", getPlayer2Name)
                startActivity(intent)
            }
        }

        binding.skipBtn.setOnClickListener(){
            val getPlayer1Name = "Player 1"
            val getPlayer2Name = "Player 2"

            val intent = Intent(this, Game2::class.java)
            intent.putExtra("player_one", getPlayer1Name)
            intent.putExtra("player_two", getPlayer2Name)
            startActivity(intent)
        }
    }
}