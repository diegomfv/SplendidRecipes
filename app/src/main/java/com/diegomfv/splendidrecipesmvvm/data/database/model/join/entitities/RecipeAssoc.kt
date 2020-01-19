package com.diegomfv.splendidrecipesmvvm.data.database.model.join.entitities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.diegomfv.splendidrecipesmvvm.data.database.constants.CUISINE_ID
import com.diegomfv.splendidrecipesmvvm.data.database.constants.DISH_TYPE_ID
import com.diegomfv.splendidrecipesmvvm.data.database.constants.RECIPE_ID
import com.diegomfv.splendidrecipesmvvm.data.database.model.join.RecipeCuisineJoin
import com.diegomfv.splendidrecipesmvvm.data.database.model.join.RecipeDishTypeJoin
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.CuisineDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.DishTypeDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.RecipeDbDTO

data class RecipeAssoc(

    @Embedded
    val recipe: RecipeDbDTO,

    @Relation(
        parentColumn = RECIPE_ID,
        entityColumn = CUISINE_ID,
        associateBy = Junction(
            value = RecipeCuisineJoin::class))
    val cuisines: List<CuisineDbDTO>,

    @Relation(
        parentColumn = RECIPE_ID,
        entityColumn = DISH_TYPE_ID,
        associateBy = Junction(
            value = RecipeDishTypeJoin::class))
    val dishTypes: List<DishTypeDbDTO>
)