package com.diegomfv.splendidrecipesmvvm.utils

import com.diegomfv.domain.Recipe
import com.diegomfv.splendidrecipesmvvm.data.database.model.join.entitities.RecipeCuisineJoin
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.CuisineDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.DishTypeDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.RecipeDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.RestrictionDbDTO
import kotlin.random.Random

object TestUtil {

    fun createRecipeDTO (id: Long) : RecipeDbDTO {
        return RecipeDbDTO(
            id = id,
            recipeName = "Title$id",
            imageUrl = "",
            readyInMinutes = 0
        )
    }

    fun createCuisineDbDTO (id: Long = 0, cuisineName: String? = null) : CuisineDbDTO {
        return CuisineDbDTO(
            cuisineId = id,
            cuisineName = cuisineName ?: "Cuisine$id"
        )
    }

    fun createRestrictionDbDTO (id: Long) : RestrictionDbDTO {
        return RestrictionDbDTO(
            restrictionId = id,
            restriction = "Restriction$id"
        )
    }

    fun createDishTypeDbDTO (id: Long) : DishTypeDbDTO {
        return DishTypeDbDTO(
            dishTypeId = id,
            dishTypeName = "DishType$id"
        )
    }

    fun createRecipeCuisineJoin (recipeID: Long, cuisineId: Long) : RecipeCuisineJoin {
        return RecipeCuisineJoin(
            recipeID,
            cuisineId
        )
    }

    var idRecipeCounter : Long = 0

    fun createRecipe (name: String, listCuisines: List<String>, listDishTypes: List<String>) : Recipe {
        return Recipe(
            id = ++idRecipeCounter,
            title = name,
            cuisines = listCuisines,
            imageUrl = "empty",
            dishTypes = listDishTypes,
            readyInMinutes = Random.nextInt(0, 100),
            ingredients = listOf()
        )
    }

}