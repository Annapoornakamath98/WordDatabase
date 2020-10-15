package com.yml.worddb

import androidx.lifecycle.LiveData

class WordRepository(private val wordDAO: WordDAO) {
    val allWords:List<Wordc> = wordDAO.getWords()
    fun insert(wordc: Wordc){
        wordDAO.insert(wordc)
    }
}