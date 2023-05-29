package com.example.kotlin_haritalar.rooms

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlin_haritalar.yer
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface daoInterface {

    @Query("SELECT * FROM yer")
    fun getAll() : Flowable<List<yer>>

    @Insert
    fun insert(place:yer) : Completable

    @Delete
    fun delete(place: yer): Completable
}