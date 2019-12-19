package com.diegomfv.splendidrecipesmvvm.data.server

import com.diegomfv.splendidrecipesmvvm.data.model.dto.RandomRecipesResult
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SpoonacularServerEndpoints {

    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("recipes/random")
    fun getRandomRecipes(
        @Query("limitLicense") limitLicense: Boolean,
        @Query("tags") tags: String,
        @Query("number") amountOfRecipes: Int,
        @Query("apiKey") key: String
    ): Deferred<RandomRecipesResult>

}