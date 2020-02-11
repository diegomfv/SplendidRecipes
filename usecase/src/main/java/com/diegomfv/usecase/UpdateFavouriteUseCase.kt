package com.diegomfv.usecase

import com.diegomfv.data.repository.RecipesRepository
import com.diegomfv.domain.Recipe

class UpdateFavouriteUseCase (
    private val recipesRepository: RecipesRepository
) {

    suspend fun invoke(recipeId: Long, favourite: Boolean) {
        return recipesRepository.updateRecipe(recipeId, favourite)
    }
}