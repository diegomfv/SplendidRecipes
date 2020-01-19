package com.diegomfv.splendidrecipesmvvm.data.database.model.join.entitities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.diegomfv.splendidrecipesmvvm.data.database.constants.CUISINE_ID
import com.diegomfv.splendidrecipesmvvm.data.database.constants.RECIPE_ID
import com.diegomfv.splendidrecipesmvvm.data.database.model.join.RecipeCuisineJoin
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.CuisineDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.RecipeDbDTO

data class RecipeCuisineAssoc(

    @Embedded
    val recipe: RecipeDbDTO,

    @Relation(
        parentColumn = RECIPE_ID,
        entityColumn = CUISINE_ID,
        associateBy = Junction(
            value = RecipeCuisineJoin::class))
    val cuisine: List<CuisineDbDTO>
)