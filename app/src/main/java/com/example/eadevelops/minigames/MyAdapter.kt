package com.example.eadevelops.minigames

import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val items: ArrayList<Games>, private val listener: GameClicked) : RecyclerView.Adapter<GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_minigames,parent,false)
        val viewHolder = GameViewHolder(view)
        view.setOnClickListener{
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val currItem = items[position]
        holder.tagText.text = currItem.title
        holder.image.setImageResource(currItem.image)
    }
}

class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tagText : TextView = itemView.findViewById(R.id.title)
    val image : ShapeableImageView = itemView.findViewById(R.id.image)
}

interface GameClicked {
    fun onItemClicked(item: Games)
}