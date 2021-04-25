package com.example.krim_guide.db

import androidx.lifecycle.LiveData

class ObjectDescRepository(private val objectDescDao: ObjectDescDao) {
    val getAllObjectDesc: LiveData<List<ObjectDesc>> = objectDescDao.getAllObjectDesc()
    suspend fun insertObjectDesc(objectDesc: ObjectDesc){
        objectDescDao.insertObjectDesc(objectDesc)
    }
    fun getObjectDescByCategory(category: String): LiveData<List<ObjectDesc>>{
        return objectDescDao.getObjectDescByCategory(category)
    }
    fun getObjectDescById(id: Int?): LiveData<ObjectDesc>{
        return objectDescDao.getObjectDescById(id)
    }

    fun searchDatabase(searchQuery: String): LiveData<List<ObjectDesc>> {
        return objectDescDao.searchDatabase(searchQuery)
    }
}