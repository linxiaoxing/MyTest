package com.example.musicplayersam.repository.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.musicplayersam.AppContext
import com.example.musicplayersam.repository.db.dao.KeyValueDao
import com.example.musicplayersam.repository.db.dao.LocalMusicDao
import com.example.musicplayersam.repository.db.entity.KeyValueEntity
import com.example.musicplayersam.repository.db.entity.LocalMusic

@Database(
    entities = [LocalMusic::class, KeyValueEntity::class],
    version = 1,
    exportSchema = false
)
abstract class QuietDatabase : RoomDatabase() {

    abstract fun localMusicDao(): LocalMusicDao

    abstract fun keyValueDao(): KeyValueDao

    companion object {

        private const val DB_NAME = "quiet.db"

        val instance: QuietDatabase by lazy {
            Room.databaseBuilder(AppContext, QuietDatabase::class.java, DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }

    }
}