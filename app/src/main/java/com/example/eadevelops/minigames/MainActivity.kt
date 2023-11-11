package com.example.eadevelops.minigames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eadevelops.minigames.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), GameClicked {

    private lateinit var binding : ActivityMainBinding
    private lateinit var gamesArrayList: ArrayList<Games>
    lateinit var nameID : ArrayList<String>
    lateinit var imgID : ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameID = arrayListOf(
            "Spin the arrow",
            "Tic Tac Toe",
            "Roll the dice",
            "Toss a coin"
        )

        imgID = arrayListOf(
            R.drawable.spin_the_arrow_icon,
            R.drawable.tick_tack_toe_logo,
            R.drawable.dice_icon,
            R.drawable.toss_icon
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        gamesArrayList = arrayListOf<Games>()
        fetchData()
    }

    private fun fetchData(){
        for(i in imgID.indices){
            val gameNo = Games(
                nameID[i], imgID[i]
            )
            gamesArrayList.add(gameNo)
        }
        binding.recyclerView.adapter = MyAdapter(gamesArrayList, this)
    }

    override fun onItemClicked(item: Games) {
        Toast.makeText(this, "you clicked $item", Toast.LENGTH_SHORT).show()
        when (item.title) {
            "Spin the arrow" -> {
                startActivity(Intent(this, Game1::class.java))
            }
            "Tic Tac Toe" -> {
                startActivity(Intent(this, Add_Players::class.java))
            }
            "Roll the dice" ->{
                startActivity(Intent(this, Game3::class.java))
            }
            else -> {
                startActivity(Intent(this, Game4::class.java))
            }
        }

    }
}