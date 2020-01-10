package com.diegomfv.data.source

import com.diegomfv.data.common.Response
import com.diegomfv.domain.Recipe

interface RemoteDataSource {
    suspend fun getRandomRecipes(tags: String, amountOfRecipes : Int, key: String): Response<List<Recipe>>
}