package com.example.finalproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Alarm::class), version=1, exportSchema = false)
abstract class AlarmRoomDatabase:RoomDatabase() {

    abstract fun alarmDao(): AlarmDao

    private class AlarmDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var alarmDao = database.alarmDao()
                }
            }
        }
    }

        companion object {
            // Singleton prevents multiple instances of database opening at the
            // same time.
            @Volatile
            private var INSTANCE: AlarmRoomDatabase? = null

            fun getDatabase(context: Context, scope: CoroutineScope): AlarmRoomDatabase {

                val tempInstance = INSTANCE
                if (tempInstance != null) {
                    return tempInstance
                }
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AlarmRoomDatabase::class.java,
                        "alarm_database"
                    ).addCallback(AlarmDatabaseCallback(scope)).build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }