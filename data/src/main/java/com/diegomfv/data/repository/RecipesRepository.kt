package com.diegomfv.data.repository

import com.diegomfv.data.source.LocalDataSource
import com.diegomfv.data.source.LocationDataSource
import com.diegomfv.domain.Recipe

class RecipesRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: LocalDataSource,
    private val locationDataSource: LocationDataSource,
    private val apiKey: String
) {

    suspend fun getPopularRecipes() : List<Recipe> {
        TODO("getPopularRecipes")
    }

    suspend fun getRecipeById(id: Int) {
        TODO("getRecipeById")
    }

    suspend fun updateRecipe() {
        TODO("updateRecipe")
    }

}