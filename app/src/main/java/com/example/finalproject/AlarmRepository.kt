package com.example.finalproject

import androidx.lifecycle.LiveData


// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class AlarmRepository(private val alarmDao: AlarmDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Alarm>> = alarmDao.getAlphabetizedWords()

    suspend fun insert(alarm: Alarm) {
        alarmDao.insert(alarm)
    }
}