package com.diegomfv.splendidrecipesmvvm.data.database.model.main

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diegomfv.splendidrecipesmvvm.data.database.constants.INGREDIENT
import com.diegomfv.splendidrecipesmvvm.data.database.constants.INGREDIENT_ID
import com.diegomfv.splendidrecipesmvvm.data.database.constants.MEASUREMENT

@Entity  (tableName = INGREDIENT)
data class IngredientDbDTO (

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = INGREDIENT_ID)
    val ingredientId: Long? = null,

    @ColumnInfo(name = INGREDIENT)
    val ingredient: String,

    @ColumnInfo (name = MEASUREMENT)
    val measurement: String

)