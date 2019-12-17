package com.diegomfv.data.source

import com.diegomfv.domain.Recipe

interface RemoteDataSource {
    suspend fun getRandomRecipes(tags: String, amountOfRecipes : Int): List<Recipe>
}