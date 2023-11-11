package com.example.eadevelops.minigames

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.eadevelops.minigames.databinding.ActivityGame2Binding


class Game2 : AppCompatActivity() {

    enum class Turn{
        NOUGHT,
        CROSS
    }

    private var firstTurn = Turn.CROSS
    private var currTurn = Turn.CROSS

    private var Xwins = 0
    private var Owins = 0

    private var boardList = mutableListOf<Button>()

    private lateinit var binding: ActivityGame2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGame2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val p1Name = intent.getStringExtra("player_one")
        val p2Name = intent.getStringExtra("player_two")

        binding.player1Name.text = p1Name
        binding.player2Name.text = p2Name

        inItBoard()
    }

    private fun inItBoard() {
        boardList.add(binding.a1)
        boardList.add(binding.a2)
        boardList.add(binding.a3)
        boardList.add(binding.b1)
        boardList.add(binding.b2)
        boardList.add(binding.b3)
        boardList.add(binding.c1)
        boardList.add(binding.c2)
        boardList.add(binding.c3)
    }

    private fun fullBoard(): Boolean {
        for (buttton in boardList){
            if (buttton.text == ""){
                return false
            }
        }
        return true
    }

    fun boardTapped(view: View){
        if(view !is Button)
            return
        addToBoard(view)

        if(checkForVictory(NOUGHT)){
            Owins++
            var winner = ""
            binding.player2wins.text = Owins.toString()

            result("${binding.player2Name.text} Wins")
        }

        if(checkForVictory(CROSS)){
            Xwins++
            var winner = ""
            binding.player1wins.text = Xwins.toString()

            result("${binding.player1Name.text} Wins")
        }

        if (fullBoard()){
            result("Draw")
        }
    }

    private fun checkForVictory(s: String): Boolean {
        //Horizontal
        if(match(binding.a1, s) && match(binding.a2, s) && match(binding.a3, s))
            return  true

        if(match(binding.b1, s) && match(binding.b2, s) && match(binding.b3, s))
            return  true

        if(match(binding.c1, s) && match(binding.c2, s) && match(binding.c3, s))
            return  true

        //Vertical
        if(match(binding.a1, s) && match(binding.b1, s) && match(binding.c1, s))
            return  true

        if(match(binding.a2, s) && match(binding.b2, s) && match(binding.c2, s))
            return  true

        if(match(binding.a3, s) && match(binding.b3, s) && match(binding.c3, s))
            return  true

        //Diagonal
        //Vertical
        if(match(binding.a1, s) && match(binding.b2, s) && match(binding.c3, s))
            return  true

        if(match(binding.a3, s) && match(binding.b2, s) && match(binding.c1, s))
            return  true

        return false
    }

    private fun match(button: Button, symbol: String) : Boolean{
        if(button.text == symbol){
            return true
        }
        return false
    }

    private fun result(title: String) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setPositiveButton("Reset")
            {_,_->
                resetBoard()
            }
            .setCancelable(false)
            .show()
            .window?.setBackgroundDrawableResource(android.R.color.holo_blue_dark)
    }

    private fun resetBoard() {
        for(button in boardList){
            button.text = ""
        }

        if (firstTurn == Turn.NOUGHT){
            firstTurn = Turn.CROSS
        }else if (firstTurn == Turn.CROSS){
            firstTurn = Turn.NOUGHT
        }
        currTurn = firstTurn
    }

    private fun addToBoard(button: Button) {
        if(button.text != "")
            return
        if (currTurn == Turn.NOUGHT){
            button.text = NOUGHT
            currTurn = Turn.CROSS
        }else if (currTurn == Turn.CROSS){
            button.text = CROSS
            currTurn = Turn.NOUGHT
        }
    }

    companion object {
        const val NOUGHT = "O"
        const val CROSS = "X"
    }
}
