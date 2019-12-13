package com.example.finalproject

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alarm_table")
data class Alarm(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    @NonNull
    @ColumnInfo(name = "hour") var hour: Int,
    @ColumnInfo(name ="min") var min: Int,
    @ColumnInfo(name = "day") var day: String)
