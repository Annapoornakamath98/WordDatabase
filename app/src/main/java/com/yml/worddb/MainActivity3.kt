package com.yml.worddb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class MainActivity3 : AppCompatActivity() {

    private lateinit var editr:EditText
    private lateinit var roomRecyclerView: RecyclerView
    private lateinit var database: WordRoomDatabase
    lateinit var roomdoneb:Button
    lateinit var roomdis:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        roomRecyclerView=findViewById(R.id.roomRecycler)
        roomdoneb=findViewById(R.id.roomdone)
        editr=findViewById(R.id.roomedit1)
        roomdis=findViewById(R.id.dis)
        roomRecyclerView.layoutManager=LinearLayoutManager(this)
        database=Room.databaseBuilder(this,WordRoomDatabase::class.java,"word_database").build()
        fun insertData(item:Wordc){
            Thread{
                database.wordDao().insert(item)
                //database.wordDao().deleteAll()

            }.start()
        }
        fun readData(){
            val list:ArrayList<Wordc> =ArrayList()
            Thread{
                list.addAll(database.wordDao().getWords())
                roomRecyclerView.post {
                    if(list.isEmpty())
                        Toast.makeText(this,"Empty",Toast.LENGTH_SHORT).show()
                    else{
                        val uList:ArrayList<String> = ArrayList()
                        list.forEach{uList.add(it.word)}
                        roomRecyclerView.adapter=WordListAdapter(uList)
                    }
                }
            }.start()

        }
        roomdoneb.setOnClickListener {
            insertData(Wordc(editr.text.toString()))
            Toast.makeText(applicationContext,"Success",Toast.LENGTH_SHORT).show()
        }
        roomdis.setOnClickListener {
            readData()

        }


    }
}