package com.diegomfv.data.repository

import com.diegomfv.data.common.Response
import com.diegomfv.data.source.RemoteDataSource
import com.diegomfv.domain.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipesRepository(
//    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
//    private val locationDataSource: LocationDataSource,

    //TODO Why is the key injected here and not later?
    private val key: String ) {

    suspend fun getRandomRecipes(tags: String, amountOfRecipes: Int = 5) : Response<List<Recipe>> {
        return withContext(Dispatchers.IO) {
            remoteDataSource.getRandomRecipes(tags, amountOfRecipes, key)
        }
    }

    suspend fun getRecipeById(id: Int) {
        TODO("getRecipeById")
    }

    suspend fun updateRecipe() {
        TODO("updateRecipe")
    }

}