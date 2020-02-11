package com.diegomfv.usecase

import com.diegomfv.data.repository.RecipesRepository
import com.diegomfv.domain.Recipe

class GetRecipeByIdUseCase (
    private val recipesRepository: RecipesRepository
) {

    suspend fun invoke(recipeId: Long): Recipe {
        return recipesRepository.getRecipeById(recipeId)
    }
}