package com.diegomfv.splendidrecipesmvvm.data.database.model.join.entitities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.diegomfv.splendidrecipesmvvm.data.database.constants.*
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.CuisineDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.DishTypeDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.RecipeDbDTO

@Entity(
    tableName = RECIPE_DISH_TYPE_TABLE_NAME,
    primaryKeys = [RECIPE_ID, DISH_TYPE_ID],
    foreignKeys = [
        ForeignKey(
            entity = RecipeDbDTO::class,
            parentColumns = [RECIPE_ID],
            childColumns = [RECIPE_ID],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = DishTypeDbDTO::class,
            parentColumns = [DISH_TYPE_ID],
            childColumns = [DISH_TYPE_ID],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RecipeDishTypeJoin(
    @ColumnInfo(name = RECIPE_ID) val recipeId: Long,
    @ColumnInfo(name = DISH_TYPE_ID) val dishTypeId: Long
)