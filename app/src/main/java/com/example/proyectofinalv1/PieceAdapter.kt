package com.example.proyectofinalv1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinalv1.model.Piece
import kotlinx.android.synthetic.main.activity_main.view.*

class PieceAdapter(private val pieces: List<Piece>) : RecyclerView.Adapter<PieceAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.titulo
        val chapter : TextView = itemView.chapter
        val cover_images: ImageView = itemView.image
        val cover: TextView = itemView.cover
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
        val view  =  LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount() =pieces.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
        val piece = pieces[position]
        holder.title.text = piece.title
        holder.chapter.text = piece.chapter
        holder.cover.text = piece.cover_characters
    }
}