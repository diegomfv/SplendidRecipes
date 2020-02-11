package com.diegomfv.splendidrecipesmvvm.data.server

import com.diegomfv.data.common.Response
import com.diegomfv.data.source.RemoteDataSource
import com.diegomfv.domain.Recipe
import com.diegomfv.splendidrecipesmvvm.data.database.mappers.toRecipe

//TODO
class RecipeRemoteDataSource(private val recipeRetrofit: RecipeRetrofit) : RemoteDataSource {

    override suspend fun getRandomRecipes(tags: String, amountOfRecipes : Int, key: String): Response<List<Recipe>> {
        return try {

            val response = recipeRetrofit.spoonacularServerEndpoints
                .getRandomRecipes(
                    limitLicense = false,
                    tags = tags,
                    amountOfRecipes = amountOfRecipes,
                    key = key
                )
                .await()
                .recipeServerDTOS
                ?.map { it.toRecipe() } ?: listOf()

            Response.Success(response)

        } catch (e: Exception) {
            Response.Failure(e)
        }
    }

}