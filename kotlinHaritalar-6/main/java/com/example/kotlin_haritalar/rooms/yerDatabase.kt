package com.example.kotlin_haritalar.rooms

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlin_haritalar.yer

@Database(entities = [yer::class], version = 1)
abstract class yerDatabase : RoomDatabase() {
    abstract fun YerDao() : daoInterface
}