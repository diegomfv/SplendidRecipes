package com.diegomfv.splendidrecipesmvvm.data.database.model.join

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import com.diegomfv.splendidrecipesmvvm.data.database.constants.CUISINE_ID
import com.diegomfv.splendidrecipesmvvm.data.database.constants.RECIPE_CUISINE_TABLE_NAME
import com.diegomfv.splendidrecipesmvvm.data.database.constants.RECIPE_ID
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.CuisineDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.RecipeDbDTO

@Entity(
    tableName = RECIPE_CUISINE_TABLE_NAME,
    primaryKeys = [RECIPE_ID, CUISINE_ID],
    foreignKeys = [
        ForeignKey(
            entity = RecipeDbDTO::class,
            parentColumns = [RECIPE_ID],
            childColumns = [RECIPE_ID],
            onUpdate = CASCADE,
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = CuisineDbDTO::class,
            parentColumns = [CUISINE_ID],
            childColumns = [CUISINE_ID],
            onUpdate = CASCADE,
            onDelete = CASCADE
        )
    ]
)
data class RecipeCuisineJoin(
    @ColumnInfo(name = RECIPE_ID) val recipeId: Long,
    @ColumnInfo(name = CUISINE_ID) val cuisineId: Long
)