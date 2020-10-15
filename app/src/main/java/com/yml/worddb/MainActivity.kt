package com.yml.worddb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var done:Button
    lateinit var show:Button
    lateinit var roomBtn:Button
    lateinit var editText: EditText
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        done=findViewById(R.id.done)
        show=findViewById(R.id.show)
        editText=findViewById(R.id.edit)
        textView=findViewById(R.id.text)
        roomBtn=findViewById(R.id.roomBtn)
        roomBtn.setOnClickListener {
            intent= Intent(applicationContext,MainActivity3::class.java)
            startActivity(intent)
        }
       done.setOnClickListener {
           if(editText.text.toString().isNotEmpty())
           {
               val user=Words(editText.text.toString())
               val dbHandler=DatabaseHelper(this)
               dbHandler.addWords(user)
               //Toast.makeText(this,editText.text.toString()+ "Added",Toast.LENGTH_LONG).show()
           }
           else{
               Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show()
           }
       }
        show.setOnClickListener {
            intent= Intent(applicationContext,MainActivity2::class.java)
            startActivity(intent)
//            textView.text=""
//            val dbHandler=DatabaseHelper(this)
//            val cursor=dbHandler.getAllWords()
//            cursor!!.moveToFirst()
//            textView.append((cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME))))
//            while(cursor.moveToNext()){
//                textView.append((cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME))))
//                textView.append("\n")
//            }
//            cursor.close()
        }
    }
}