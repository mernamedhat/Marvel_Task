package com.example.marvel.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.MarvelChar

import com.example.marvel.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.search_item.view.*

class SearchAdapter(var data: ArrayList<MarvelChar>) :
    RecyclerView.Adapter<SearchAdapter.ViewHolderIndex>() {

    class ViewHolderIndex(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(character: MarvelChar) {
            val name = itemView.search_name as TextView
            name.text = character.name
            val img = itemView.search_img_item as ImageView
            Picasso.get()
                .load(character.thumbnail.path + "." + character.thumbnail.extension)
                .placeholder(R.drawable.marvel)
                .into(img)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolderIndex {
        val myViewInflater =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.search_item, viewGroup, false)
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