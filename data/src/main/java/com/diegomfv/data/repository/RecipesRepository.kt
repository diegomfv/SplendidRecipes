package com.diegomfv.data.repository

import com.diegomfv.data.source.LocalDataSource
import com.diegomfv.data.source.LocationDataSource
import com.diegomfv.data.source.RemoteDataSource
import com.diegomfv.domain.Recipe

class RecipesRepository(
//    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
//    private val locationDataSource: LocationDataSource,

    //TODO Why is the key injected here?
    private val key: String ) {

    suspend fun getRandomRecipes(tags: String, amountOfRecipes: Int = 5) : List<Recipe> {
        return remoteDataSource.getRandomRecipes(tags, amountOfRecipes, key)
    }

    suspend fun getRecipeById(id: Int) {
        TODO("getRecipeById")
    }

    suspend fun updateRecipe() {
        TODO("updateRecipe")
    }

}