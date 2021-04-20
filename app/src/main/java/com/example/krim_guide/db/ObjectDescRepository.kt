package com.example.krim_guide.db

import androidx.lifecycle.LiveData

class ObjectDescRepository(private val objectDescDao: ObjectDescDao) {
    val getAllObjectDesc: LiveData<List<ObjectDesc>> = objectDescDao.getAllObjectDesc()
    suspend fun insertObjectDesc(objectDesc: ObjectDesc){
        objectDescDao.insertObjectDesc(objectDesc)
    }
}