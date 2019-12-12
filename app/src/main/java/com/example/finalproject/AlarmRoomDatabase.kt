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
                    alarmDao.deleteAll()
                    var alarm = Alarm(1, 2, 3, "W")
                    alarmDao.insert(alarm)
                    alarm = Alarm(3, 4, 30, "M")
                    alarmDao.insert(alarm)
                    alarm = Alarm(2, 4, 20, "M")
                    alarmDao.insert(alarm)

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
                        "word_database"
                    ).addCallback(AlarmDatabaseCallback(scope)).build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }