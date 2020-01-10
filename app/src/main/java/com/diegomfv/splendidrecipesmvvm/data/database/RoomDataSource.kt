package com.diegomfv.splendidrecipesmvvm.data.database

import com.diegomfv.data.source.LocalDataSource
import com.diegomfv.splendidrecipesmvvm.data.fromDatabaseToDomain
import com.diegomfv.splendidrecipesmvvm.data.fromDomainToDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.diegomfv.domain.Recipe as RecipeDomain


class RoomDataSource(db: RecipesDatabase) : LocalDataSource {

    private val recipeDao = db.recipeDao()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO) { recipeDao.movieCount() <= 0 }

    override suspend fun saveRecipes(movies: List<RecipeDomain>) {
        withContext(Dispatchers.IO) { recipeDao.movieCount() <= 0 }
    }

    override suspend fun getPopularRecipes(): List<RecipeDomain> {
        return recipeDao.getAllRecipes().map { it.fromDatabaseToDomain() }
    }

    override suspend fun findById(id: Int): RecipeDomain {
        return recipeDao.findById(id).fromDatabaseToDomain()
    }

    override suspend fun update(recipe: RecipeDomain) {
        withContext(Dispatchers.IO) { recipeDao.updateRecipe(recipe.fromDomainToDatabase()) }
    }
}