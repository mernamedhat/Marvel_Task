package com.example.marvel.Ui.Home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.MarvelChar
import com.example.marvel.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*

class MainAdapter(var data: ArrayList<MarvelChar>) :
    RecyclerView.Adapter<MainAdapter.ViewHolderIndex>() {

    class ViewHolderIndex(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(character: MarvelChar) {
            val name = itemView.MarvelName as TextView
            name.text = character.name
            val img = itemView.MarvelImg as ImageView
            Picasso.get().load(character.thumbnail.path + "." + character.thumbnail.extension)
                .placeholder(R.drawable.marvel).resize(685, 300).into(img)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolderIndex {
        val myViewInflater =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.recycler_item, viewGroup, false)
        return ViewHolderIndex(myViewInflater)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolderIndex, position: Int) {
        val data = data[position]
        holder.bind(data)
    }
}