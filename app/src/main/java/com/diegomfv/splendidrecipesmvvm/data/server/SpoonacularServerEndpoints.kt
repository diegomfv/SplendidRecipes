package com.diegomfv.splendidrecipesmvvm.data.server

import com.diegomfv.splendidrecipesmvvm.data.model.dto.Recipes
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface SpoonacularServerEndpoints {

    @GET("discover/movie?sort_by=popularity.desc")
    fun getRandomRecipes(
        @Query("limitLicense") limitLicense: Boolean,
        @Query("tags") tags: String,
        @Query("number") amountOfRecipes: Int
    ): Deferred<Recipes>

}