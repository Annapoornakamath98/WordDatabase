package com.yml.worddb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val userList: ArrayList<String>):RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.word_list,parent,false)
        return ViewHolder(v)
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
            val textItem=itemView.findViewById<TextView>(R.id.textWord)

    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.textItem.text= userList[position].toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}