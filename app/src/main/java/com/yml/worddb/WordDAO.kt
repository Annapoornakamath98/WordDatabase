package com.yml.worddb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDAO {
    @Query("SELECT * FROM word_table ORDER BY wordcol ASC")
    fun getOrderedWords():LiveData<List<Wordc>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(wordc: Wordc)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}