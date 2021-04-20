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

    @Query("SELECT * FROM ObjectDesc")
    fun getAllObjectDesc(): LiveData<List<ObjectDesc>>
}