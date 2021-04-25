package com.example.krim_guide.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ObjectDescDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertObjectDesc(objectDesc: ObjectDesc)

    @Update
    fun updateObjectDesc(objectDesc: ObjectDesc)

    @Delete
    fun deleteObjectDesc(objectDesc: ObjectDesc)

    @Query("SELECT * FROM ObjectDesc WHERE name == :name")
    fun getObjectDescByName(name: String): List<ObjectDesc>

    @Query("SELECT * FROM ObjectDesc WHERE id == :id")
    fun getObjectDescById(id: Int?): LiveData<ObjectDesc>

    @Query("SELECT * FROM ObjectDesc WHERE category == :category")
    fun getObjectDescByCategory(category: String):LiveData<List<ObjectDesc>>

    @Query("SELECT * FROM ObjectDesc")
    fun getAllObjectDesc(): LiveData<List<ObjectDesc>>

    @Query("SELECT * FROM ObjectDesc WHERE name LIKE :searchQuery ")
    fun searchDatabase(searchQuery: String): LiveData<List<ObjectDesc>>
}