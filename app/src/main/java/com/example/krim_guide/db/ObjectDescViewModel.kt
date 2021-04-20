package com.example.krim_guide.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ObjectDescViewModel(application: Application): AndroidViewModel(application){
    private val getAllObjectDesc: LiveData<List<ObjectDesc>>
    private val repository: ObjectDescRepository

    init {
        val objectDescDao = DataBase.getAppDataBase(application).objectDescDao()
        repository = ObjectDescRepository(objectDescDao)
        getAllObjectDesc = repository.getAllObjectDesc
    }


}