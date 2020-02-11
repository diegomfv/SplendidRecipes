package com.diegomfv.splendidrecipesmvvm.data.database.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.diegomfv.splendidrecipesmvvm.data.database.constants.*


//TODO Delete when possible

@Entity(tableName = RECIPE_TABLE_NAME,
    indices = [Index(value = [RECIPE_ID], unique = true)]
)
data class RecipeDbTemp (

    //Server Recipe Id
    @PrimaryKey
    @ColumnInfo(name = RECIPE_ID)
    val id: Long,

    @ColumnInfo(name = RECIPE_NAME)
    val title: String,

    @ColumnInfo(name = IMAGE_URL)
    val imageUrl: String,

    @ColumnInfo(name = CUISINES)
    val cuisines: List<String>,

    @ColumnInfo(name = DISHTYPES)
    val dishTypes: List<String>,

    @ColumnInfo(name = READY_IN_MINUTES)
    val readyInMinutes: Int,

    @ColumnInfo(name = INGREDIENTS)
    val ingredients: List<String>,

    @ColumnInfo(name = FAVOURITE)
    val favourite: Boolean

)