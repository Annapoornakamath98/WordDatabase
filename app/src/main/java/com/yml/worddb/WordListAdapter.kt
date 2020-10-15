package com.yml.worddb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter internal constructor(context: Context):RecyclerView.Adapter<WordListAdapter.WordViewHolder>(){
    private val inflater:LayoutInflater= LayoutInflater.from(context)
    private var words= emptyList<Wordc>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WordListAdapter.WordViewHolder {
        val itemView=inflater.inflate(R.layout.room_wordlist,parent,false)
        return WordViewHolder(itemView)
    }

    class WordViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val wordItemView:TextView=itemView.findViewById(R.id.textRoom)

    }

    override fun onBindViewHolder(holder: WordListAdapter.WordViewHolder, position: Int) {
        val current=words[position]
        holder.wordItemView.text=current.word
    }
    internal fun setWords(words:List<Wordc>){
        this.words=words
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return words.size
    }

}