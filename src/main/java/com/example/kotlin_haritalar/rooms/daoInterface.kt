package com.example.kotlin_haritalar.rooms

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlin_haritalar.yer

@Dao
interface daoInterface {

    @Query("SELECT * FROM yer")
    fun getAll() : List<yer>

    @Insert
    fun insert(place:yer)

    @Delete
    fun delete(place: yer)
}