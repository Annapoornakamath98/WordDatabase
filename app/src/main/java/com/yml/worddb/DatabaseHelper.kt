package com.yml.worddb

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns._ID
import android.widget.Toast


class DatabaseHelper(var context: Context?) :SQLiteOpenHelper(context,DATABASE_NAME,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable=
                "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,$COL_NAME TEXT)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //db?.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME)
        //onCreate(db)
    }
    companion object{
        val DATABASE_NAME="MY DATABASE"
        val TABLE_NAME="Words"
        val COL_NAME="word"
        val COL_ID="id"
    }
    fun addWords(word: Words){
        val values=ContentValues()
        values.put(COL_NAME,word.userWord)
        val db=this.writableDatabase
        val res=db.insert(TABLE_NAME,null,values)
        if(res==-1.toLong())
        {
            Toast.makeText(context,"fail",Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(context,"success",Toast.LENGTH_SHORT).show()
    }
    fun getAllWords():ArrayList<String>{
        val db=this.readableDatabase
        val list=ArrayList<String>()
        val query="SELECT * FROM $TABLE_NAME"
        val result=db.rawQuery(query,null)
        if(result.moveToFirst()){
            do{
                val word=result.getString((result.getColumnIndex(COL_NAME)))
                list.add(word)
            }while (result.moveToNext())
        }
        return list
    }

}