package com.yml.worddb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity3 : AppCompatActivity() {
    lateinit var wordViewModel: WordViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val recyclerView=findViewById<RecyclerView>(R.id.roomRecycler)
        val adapter=WordListAdapter(this)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)

    }
}