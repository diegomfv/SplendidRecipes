package com.diegomfv.data.repository

import com.diegomfv.data.common.Response
import com.diegomfv.data.source.LocalDataSource
import com.diegomfv.data.source.RemoteDataSource
import com.diegomfv.domain.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipesRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,

    //TODO Why is the key injected here and not later?
    private val key: String ) {

    //TODO Solve this
    suspend fun getRandomRecipes(tags: String, amountOfRecipes: Int) : Response<List<Recipe>> {
        return withContext(Dispatchers.IO) {

            if (localDataSource.isEmpty()) {
                val response = remoteDataSource.getRandomRecipes(tags, amountOfRecipes, key)
                when (response) {
                    is Response.Success -> {
                        localDataSource.saveRecipes(response.result)
                        Response.Success(localDataSource.getRecipesByRandom())
                    }
                    is Response.Failure -> {
                        Response.Success(localDataSource.getRecipesByRandom())
                    }
                }
            } else {
                Response.Success(localDataSource.getRecipesByRandom())
            }
        }
    }

    suspend fun getRecipeById(id: Long) : Recipe {
        return withContext(Dispatchers.IO) {
            localDataSource.getRecipeById(id)
        }
    }

    suspend fun updateRecipe(recipeId: Long, favourite: Boolean) {
        return withContext(Dispatchers.IO) { localDataSource.update(recipeId, favourite) }
    }

}