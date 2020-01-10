package com.diegomfv.splendidrecipesmvvm.data.database

import androidx.room.*
import com.diegomfv.splendidrecipesmvvm.data.database.Recipe as Recipe

@Dao
interface RecipeDao {

    @Query("SELECT * FROM Recipe")
    fun getAllRecipes(): List<Recipe>

    @Query("SELECT * FROM Recipe WHERE id = :id")
    fun findById(id: Int): Recipe

    @Query("SELECT COUNT(id) FROM Recipe")
    fun movieCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertRecipes(movies: List<Recipe>)

    @Update
    fun updateRecipe(movie: Recipe)
}