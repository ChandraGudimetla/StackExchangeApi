package com.example.retrofit_stackexchangeapi.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_stackexchangeapi.model.QuestionModel
import com.example.retrofit_stackexchangeapi.R

class ListAdapter(private val exampleList: List<QuestionModel>) :
    RecyclerView.Adapter<ListAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return CustomViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.positionNumber.text = "Question Number ${position +1}"
        holder.title.text = exampleList[position].title
        holder.link.text = exampleList[position].link
    }

    override fun getItemCount(): Int {
        return exampleList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val positionNumber: TextView = itemView.findViewById(R.id.positionNumber)
        val title: TextView = itemView.findViewById(R.id.title)
        val link: TextView = itemView.findViewById(R.id.link)
    }

}