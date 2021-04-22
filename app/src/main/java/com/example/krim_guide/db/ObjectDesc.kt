package com.example.krim_guide.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ObjectDesc(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val image: Int)

