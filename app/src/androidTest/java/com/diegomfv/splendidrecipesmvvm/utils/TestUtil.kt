package com.diegomfv.splendidrecipesmvvm.utils

import com.diegomfv.domain.Recipe
import com.diegomfv.splendidrecipesmvvm.data.database.model.entititiesjoin.RecipeCuisineAssoc
import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.CuisineDb
import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.DishTypeDb
import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.RecipeDbTemp
import kotlin.random.Random

object TestUtil {

    fun createRecipeDTO (id: Long) : RecipeDbTemp {
        return RecipeDbTemp(
            id = id,
            title = "Title$id",
            imageUrl = "",
            readyInMinutes = 0,
            cuisines = listOf(),
            dishTypes = listOf(),
            favourite = false,
            ingredients = listOf()
        )
    }

    fun createCuisineDbDTO (id: Long = 0, cuisineName: String? = null) : CuisineDb {
        return CuisineDb(
            cuisineId = id,
            cuisineName = cuisineName ?: "Cuisine$id"
        )
    }

    fun createDishTypeDbDTO (id: Long) : DishTypeDb {
        return DishTypeDb(
            dishTypeId = id,
            dishTypeName = "DishType$id"
        )
    }

    fun createRecipeCuisineJoin (recipeID: Long, cuisineId: Long) : RecipeCuisineAssoc {
        return RecipeCuisineAssoc(
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