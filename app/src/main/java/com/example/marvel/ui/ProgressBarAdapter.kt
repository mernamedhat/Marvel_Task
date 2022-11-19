package com.example.marvel.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R

class ProgressBarAdapter: RecyclerView.Adapter<ProgressBarAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            DataViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout_bar, parent, false))

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {}

    override fun getItemCount(): Int = 1

}