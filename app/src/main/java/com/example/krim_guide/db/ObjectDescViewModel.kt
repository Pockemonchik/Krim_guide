package com.example.krim_guide.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ObjectDescViewModel(application: Application): AndroidViewModel(application){


    val getAllObjectDesc: LiveData<List<ObjectDesc>>
    private val repository: ObjectDescRepository

    init {
        val objectDescDao = DataBase.getAppDataBase(application)?.objectDescDao()
        repository = ObjectDescRepository(objectDescDao!!)
        getAllObjectDesc = repository.getAllObjectDesc
    }
    fun insertObjectDesc(objectDesc: ObjectDesc) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertObjectDesc(objectDesc)
        }
    }
    fun getObjectDescByCategory(category: String): LiveData<List<ObjectDesc>> {
        return repository.getObjectDescByCategory(category)
    }

    fun getObjectDescById(id: Int?): LiveData<ObjectDesc>{
        return repository.getObjectDescById(id)
    }
    fun searchDatabase(searchQuery: String): LiveData<List<ObjectDesc>> {
        return repository.searchDatabase(searchQuery)
    }

}