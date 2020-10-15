package com.yml.worddb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDAO {
    @Query("SELECT * FROM word_table")
    fun getWords():List<Wordc>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(wordc: Wordc)

//    @Query("DELETE FROM word_table")
//    fun deleteAll()
}