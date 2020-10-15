package com.yml.worddb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Wordc::class),version = 1,exportSchema = false)
abstract class WordRoomDatabase: RoomDatabase() {
    abstract fun wordDao():WordDAO

}