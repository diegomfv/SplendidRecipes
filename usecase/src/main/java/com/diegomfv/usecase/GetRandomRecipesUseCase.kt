package com.diegomfv.usecase

import com.diegomfv.data.repository.RecipesRepository
import com.diegomfv.domain.Recipe


class GetRandomRecipesUseCase (
    val recipesRepository: RecipesRepository
) {

    suspend fun invoke(amountOfRecipes: Int = 5): List<Recipe> {
        return recipesRepository.getRandomRecipes("vegetarian", amountOfRecipes)
    }
}