package com.diegomfv.splendidrecipesmvvm.data.server

import com.diegomfv.data.source.RemoteDataSource
import com.diegomfv.domain.Recipe
import com.diegomfv.splendidrecipesmvvm.data.fromDTOToDomain
import com.diegomfv.data.common.Response
import retrofit2.HttpException

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
                .recipes
                ?.map { it.fromDTOToDomain() } ?: listOf()

            Response.Success(response)

        } catch (e: HttpException) {
            Response.Failure(e)
        }
    }

}