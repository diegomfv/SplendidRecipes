package com.diegomfv.data.source

import com.diegomfv.domain.Recipe

interface LocalDataSource {

    suspend fun isEmpty(): Boolean
    suspend fun saveRecipes(movies: List<Recipe>)
    suspend fun getPopularRecipes(): List<Recipe>
    suspend fun findById(id: Int): Recipe
    suspend fun update(recipe: Recipe)


}