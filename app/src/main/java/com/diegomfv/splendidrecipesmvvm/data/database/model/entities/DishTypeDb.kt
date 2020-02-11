package com.diegomfv.splendidrecipesmvvm.data.database.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.diegomfv.splendidrecipesmvvm.data.database.constants.DISH_TYPE_ID
import com.diegomfv.splendidrecipesmvvm.data.database.constants.DISH_TYPE_NAME
import com.diegomfv.splendidrecipesmvvm.data.database.constants.DISH_TYPE_TABLE_NAME

//@Entity (tableName = DISH_TYPE_TABLE_NAME,
//    indices = [Index(value = [DISH_TYPE_NAME], unique = true)])
//data class DishTypeDb(
//
//    @PrimaryKey (autoGenerate = true)
//    @ColumnInfo(name = DISH_TYPE_ID)
//    val dishTypeId: Long? = null,
//
//    @ColumnInfo(name = DISH_TYPE_NAME)
//    val dishTypeName: String
//
//)