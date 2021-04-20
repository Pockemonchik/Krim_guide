package com.example.krim_guide.db

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
    fun getGenderByName(name: String): List<ObjectDesc>

    @Query("SELECT * FROM ObjectDesc")
    fun getGenders(): List<ObjectDesc>
}