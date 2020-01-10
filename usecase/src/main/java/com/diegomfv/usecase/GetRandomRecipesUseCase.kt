package com.diegomfv.usecase

import com.diegomfv.data.repository.RecipesRepository
import com.diegomfv.domain.Recipe
import com.diegomfv.data.common.Response

class GetRandomRecipesUseCase (
    private val recipesRepository: RecipesRepository
) {

    suspend fun invoke(amountOfRecipes: Int = 5): Response<List<Recipe>> {
        return recipesRepository.getRandomRecipes("vegetarian", amountOfRecipes)
    }
}