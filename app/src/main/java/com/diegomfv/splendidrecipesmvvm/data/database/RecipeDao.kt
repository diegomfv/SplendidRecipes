package com.diegomfv.splendidrecipesmvvm.data.database

import androidx.room.*

@Dao
interface RecipeDao {

    @Query("SELECT * FROM RecipeDatabaseDTO")
    fun getAllRecipes(): List<RecipeDatabaseDTO>

    @Query("SELECT * FROM RecipeDatabaseDTO WHERE id = :id")
    fun findById(id: Int): RecipeDatabaseDTO

    @Query("SELECT COUNT(id) FROM RecipeDatabaseDTO")
    fun recipesCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertRecipes(movies: List<RecipeDatabaseDTO>)

    @Update
    fun updateRecipe(movie: RecipeDatabaseDTO)
}