package com.diegomfv.splendidrecipesmvvm.data.database

import com.diegomfv.data.source.LocalDataSource
import com.diegomfv.splendidrecipesmvvm.data.database.mappers.toRecipe
import com.diegomfv.splendidrecipesmvvm.data.database.mappers.toRecipeDbTemp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.diegomfv.domain.Recipe as RecipeDomain


class RoomDataSource(db: RecipesDatabase) : LocalDataSource {

    private val recipeDao = db.recipeDao()

    override suspend fun getRecipeById(recipeId: Long): RecipeDomain {
        return withContext(Dispatchers.IO) { recipeDao.getRecipeById(recipeId).toRecipe() }
    }

    //TODO Improve when association tables are created
    override suspend fun getRecipesByCuisines(
        list: List<String>,
        amount: Int
    ): List<RecipeDomain> {
        return withContext(Dispatchers.IO) {
            recipeDao.getAllRecipes()
                .filter { it.cuisines.any { list.contains(it) } }
                .map { it.toRecipe() }
        }
    }

    //TODO Improve when association tables are created
    override suspend fun getRecipesByDishTypes(
        list: List<String>,
        amount: Int
    ): List<RecipeDomain> {
        return withContext(Dispatchers.IO) {
            recipeDao.getAllRecipes()
                .filter { it.dishTypes.any { list.contains(it) } }
                .map { it.toRecipe() }
        }
    }

    //TODO Improve when association tables are created
    override suspend fun getRecipesByRandom(amount: Int): List<RecipeDomain> {
        return withContext(Dispatchers.IO) {
            recipeDao.getAllRecipes()
                .shuffled()
                .take(amount)
                .map { it.toRecipe() }
        }
    }

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO) { recipeDao.recipesCount() <= 0 }


    override suspend fun saveRecipes(recipes: List<RecipeDomain>) {
        withContext(Dispatchers.IO) { recipeDao.insertRecipes(recipes.map { it.toRecipeDbTemp() }) }
    }

    //TODO Improve
    override suspend fun update(recipeId: Long, favourite: Boolean) {
        withContext(Dispatchers.IO) {
            val recipeInDb = recipeDao.getRecipeById(recipeId)
            recipeDao.updateRecipe(recipeInDb.copy(favourite = favourite))
        }
    }
}