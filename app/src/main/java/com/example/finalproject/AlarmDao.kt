package com.example.finalproject

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AlarmDao {
    @Query("SELECT * from alarm_table ORDER BY hour,min ASC")
    fun getAlphabetizedWords(): LiveData<List<Alarm>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(alarm: Alarm)

    @Query("DELETE FROM alarm_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(alarm:Alarm)
}