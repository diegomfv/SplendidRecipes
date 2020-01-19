package com.diegomfv.splendidrecipesmvvm.data.database.model.master

import androidx.room.*
import com.diegomfv.splendidrecipesmvvm.data.database.constants.*
import com.diegomfv.splendidrecipesmvvm.data.database.model.join.entitities.RecipeCuisineJoin
import com.diegomfv.splendidrecipesmvvm.data.database.model.join.entitities.RecipeDishTypeJoin
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.CuisineDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.DishTypeDbDTO

class RecipeFromDatabase (

        val recipeId: Long,
        val title: String,
        val imageUrl: String,
        val readyInMinutes: Int,

        @Relation(
            parentColumn = RECIPE_ID,
            entityColumn = CUISINE_ID,
            associateBy = Junction(RecipeCuisineJoin::class)
        )
        val cuisines: List<CuisineDbDTO>,

        @Relation(
            parentColumn = RECIPE_ID,
            entityColumn = DISH_TYPE_ID,
            associateBy = Junction(RecipeDishTypeJoin::class)
        )
        val dishType: List<DishTypeDbDTO>

)