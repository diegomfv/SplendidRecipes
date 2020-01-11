package com.diegomfv.splendidrecipesmvvm.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecipeDatabaseDTO (
    @PrimaryKey val id: Int,
    val title: String,
    val cuisines: List<String>,
    val imageUrl: String,
    val dishTypes: List<String>,
    val readyInMinutes: Int
)