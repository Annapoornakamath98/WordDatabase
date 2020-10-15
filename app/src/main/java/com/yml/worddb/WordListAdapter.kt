package com.yml.worddb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter internal constructor(val ulist:ArrayList<String>):RecyclerView.Adapter<WordListAdapter.WordViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WordViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.room_wordlist,parent,false)
        return WordViewHolder(itemView)
    }

    class WordViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val wordItemView:TextView=itemView.findViewById(R.id.textRoom)

    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.wordItemView.text= ulist[position].toString()
    }


    override fun getItemCount(): Int {
        return ulist.size
    }

}