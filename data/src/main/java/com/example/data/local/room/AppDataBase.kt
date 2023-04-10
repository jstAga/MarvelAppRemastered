package com.example.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.room.entities.ComicEntity

@Database(entities = [ComicEntity :: class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun noteDao() : ComicsDao
}