package com.diegomfv.splendidrecipesmvvm.data.database.model.entititiesjoin

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.diegomfv.splendidrecipesmvvm.data.database.constants.*
//import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.DishTypeDb
//import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.RecipeDb

//@Entity(
//    tableName = RECIPE_DISH_TYPE_TABLE_NAME,
//    primaryKeys = [RECIPE_ID, DISH_TYPE_ID],
//    foreignKeys = [
//        ForeignKey(
//            entity = RecipeDb::class,
//            parentColumns = [RECIPE_ID],
//            childColumns = [RECIPE_ID],
//            onUpdate = ForeignKey.CASCADE,
//            onDelete = ForeignKey.CASCADE
//        ),
//        ForeignKey(
//            entity = DishTypeDb::class,
//            parentColumns = [DISH_TYPE_ID],
//            childColumns = [DISH_TYPE_ID],
//            onUpdate = ForeignKey.CASCADE,
//            onDelete = ForeignKey.CASCADE
//        )
//    ]
//)
//data class RecipeDishTypeAssoc(
//    @ColumnInfo(name = RECIPE_ID) val recipeId: Long,
//    @ColumnInfo(name = DISH_TYPE_ID) val dishTypeId: Long
//)