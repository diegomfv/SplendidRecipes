package com.diegomfv.splendidrecipesmvvm.data.database.model.main

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.diegomfv.splendidrecipesmvvm.data.database.constants.CUISINE_ID
import com.diegomfv.splendidrecipesmvvm.data.database.constants.CUISINE_NAME
import com.diegomfv.splendidrecipesmvvm.data.database.constants.CUISINE_TABLE_NAME

@Entity (tableName = CUISINE_TABLE_NAME,
    indices = [Index(value = [CUISINE_NAME], unique = true)]
)
data class CuisineDbDTO(

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = CUISINE_ID)
    val cuisineId: Long? = null,

    @ColumnInfo(name = CUISINE_NAME)
    val cuisineName: String

)
