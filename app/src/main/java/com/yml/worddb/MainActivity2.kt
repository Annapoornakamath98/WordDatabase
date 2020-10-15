package com.yml.worddb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        recycler=findViewById(R.id.recyclerView)
        val sqlDb=DatabaseHelper(this)

        recycler.layoutManager=LinearLayoutManager(this)
        val data=sqlDb.getAllWords()


//        textView.text=""
//        val dbHandler=DatabaseHelper(this)
//        val cursor=dbHandler.getAllWords()
//        cursor!!.moveToFirst()
//        textView.append((cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME))))
//        while(cursor.moveToNext()){
//
////            textView.append((cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME))))
////            textView.append("\n")
//
//        }
//        cursor.close()
        recycler.adapter=CustomAdapter(data)

    }
}