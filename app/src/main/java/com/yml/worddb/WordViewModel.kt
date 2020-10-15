package com.yml.worddb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application):AndroidViewModel(application) {
    private val repository:WordRepository
    val allWordc:LiveData<List<Wordc>>
    init {
        val wordsDao=WordRoomDatabase.getDatabase(application).wordDao()
        repository=WordRepository(wordsDao)
        allWordc=repository.allWords
    }
    fun insert(wordc: Wordc)= viewModelScope.launch(Dispatchers.IO){
        repository.insert(wordc)
    }
}