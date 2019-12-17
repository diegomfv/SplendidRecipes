package com.diegomfv.splendidrecipesmvvm.data.server

import com.diegomfv.data.source.RemoteDataSource
import com.diegomfv.domain.Recipe
import com.diegomfv.splendidrecipesmvvm.data.fromDTOToDomain

//TODO
class RecipeRemoteDataSource(private val recipeRetrofit: RecipeRetrofit) : RemoteDataSource {

    override suspend fun getRandomRecipes(tags: String, amountOfRecipes : Int): List<Recipe> =
        recipeRetrofit.spoonacularServerEndpoints
            .getRandomRecipes(limitLicense = false, tags = tags, amountOfRecipes = amountOfRecipes)
            .await()
            .recipes
            ?.map { it.fromDTOToDomain() } ?: listOf()

}