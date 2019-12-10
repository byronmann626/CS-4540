package com.example.finalproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AlarmDao {
    @Query("SELECT * from alarm_table ORDER BY hour ASC")
    fun getAlphabetizedWords(): LiveData<List<Alarm>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(alarm: Alarm)

    @Query("DELETE FROM alarm_table")
    suspend fun deleteAll()
}