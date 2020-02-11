package com.diegomfv.data.source

import com.diegomfv.domain.Recipe

interface LocalDataSource {

    suspend fun getRecipeById(recipeId: Long) : Recipe
    suspend fun getRecipesByCuisines(list: List<String>, amount: Int = 5) : List<Recipe>
    suspend fun getRecipesByDishTypes(list: List<String>, amount: Int = 5) : List<Recipe>
    suspend fun getRecipesByRandom (amount: Int = 5) : List<Recipe>

    suspend fun isEmpty(): Boolean
    suspend fun saveRecipes(recipes: List<Recipe>)

    suspend fun update(recipeId: Long, favourite: Boolean)


}