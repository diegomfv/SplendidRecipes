package com.diegomfv.splendidrecipesmvvm.data.database.model.entititiesjoin

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.diegomfv.splendidrecipesmvvm.data.database.constants.CUISINE_ID
import com.diegomfv.splendidrecipesmvvm.data.database.constants.RECIPE_CUISINE_TABLE_NAME
import com.diegomfv.splendidrecipesmvvm.data.database.constants.RECIPE_ID
//import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.CuisineDb
//import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.RecipeDb

//@Entity(
//    tableName = RECIPE_CUISINE_TABLE_NAME,
//    primaryKeys = [RECIPE_ID, CUISINE_ID],
//    foreignKeys = [
//        ForeignKey(
//            entity = RecipeDb::class,
//            parentColumns = [RECIPE_ID],
//            childColumns = [RECIPE_ID],
//            onUpdate = ForeignKey.CASCADE,
//            onDelete = ForeignKey.CASCADE
//        ),
//        ForeignKey(
//            entity = CuisineDb::class,
//            parentColumns = [CUISINE_ID],
//            childColumns = [CUISINE_ID],
//            onUpdate = ForeignKey.CASCADE,
//            onDelete = ForeignKey.CASCADE
//        )
//    ]
//)
//data class RecipeCuisineAssoc(
//    @ColumnInfo(name = RECIPE_ID) val recipeId: Long,
//    @ColumnInfo(name = CUISINE_ID) val cuisineId: Long
//)