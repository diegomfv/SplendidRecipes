package com.diegomfv.splendidrecipesmvvm.data.database.model.main

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diegomfv.splendidrecipesmvvm.data.database.constants.DISH_TYPE
import com.diegomfv.splendidrecipesmvvm.data.database.constants.DISH_TYPE_ID
import com.diegomfv.splendidrecipesmvvm.data.database.constants.DISH_TYPE_TABLE_NAME

@Entity (tableName = DISH_TYPE_TABLE_NAME)
data class DishTypeDbDTO(

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = DISH_TYPE_ID)
    val dishTypeId: Long? = null,

    @ColumnInfo(name = DISH_TYPE)
    val dishType: String

)