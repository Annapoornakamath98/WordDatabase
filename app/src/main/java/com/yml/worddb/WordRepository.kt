package com.yml.worddb

import androidx.lifecycle.LiveData

class WordRepository(private val wordDAO: WordDAO) {
    val allWords:LiveData<List<Wordc>> = wordDAO.getOrderedWords()
    suspend fun insert(wordc: Wordc){
        wordDAO.insert(wordc)
    }
}