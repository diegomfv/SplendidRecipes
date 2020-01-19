package com.diegomfv.splendidrecipesmvvm.data.database

import androidx.room.*
import com.diegomfv.domain.Recipe
import com.diegomfv.splendidrecipesmvvm.data.database.constants.*
import com.diegomfv.splendidrecipesmvvm.data.database.mappers.fromDomainToDatabaseDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.join.RecipeCuisineJoin
import com.diegomfv.splendidrecipesmvvm.data.database.model.join.entitities.RecipeCuisineAssoc
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.CuisineDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.RecipeDbDTO

@Dao
interface RecipeDao {

    @Query("SELECT * FROM $RECIPE_TABLE_NAME")
    fun getAllRecipes(): List<RecipeDbDTO>

    @Query("SELECT * FROM $CUISINE_TABLE_NAME")
    fun getAllCuisines(): List<CuisineDbDTO>

    @Transaction
    @Query("SELECT * FROM $RECIPE_CUISINE_TABLE_NAME")
    fun getAllRecipeCuisineJoin(): List<RecipeCuisineJoin>

    @Transaction
    @Query("SELECT * FROM $RECIPE_TABLE_NAME")
    fun getRecipeCuisineAssoc(): RecipeCuisineAssoc

    @Transaction
    @Query("SELECT * FROM $RECIPE_TABLE_NAME")
    fun getAllRecipeCuisineAssoc(): List<RecipeCuisineAssoc>

    @Query("SELECT * FROM $RECIPE_TABLE_NAME WHERE $RECIPE_ID = :id")
    fun findRecipeById(id: Long): RecipeDbDTO

    @Query("SELECT * FROM $CUISINE_TABLE_NAME WHERE $CUISINE_ID = :id")
    fun findCuisineById(id: Long): CuisineDbDTO

    @Query("SELECT * FROM $RECIPE_CUISINE_TABLE_NAME WHERE $RECIPE_ID = :id")
    fun findRecipeWithCuisineById(id: Int): RecipeCuisineJoin



    @Query("SELECT * FROM $RECIPE_TABLE_NAME WHERE $RECIPE_NAME = :name")
    fun findRecipeByName(name: String) : RecipeDbDTO

    @Query("SELECT * FROM $CUISINE_TABLE_NAME WHERE $CUISINE_NAME = :name")
    fun findCuisineByName(name: String) : CuisineDbDTO

//    @Query("SELECT * FROM $CUISINE_TABLE_NAME WHERE $CUISINE_NAME = :name")
//    fun findCuisinesByName(name: List<String>) : List<CuisineDbDTO>





    @Query("SELECT COUNT($RECIPE_ID) FROM $RECIPE_TABLE_NAME")
    fun recipesCount(): Int


    @Insert(entity = RecipeDbDTO::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertRecipe(recipe: RecipeDbDTO) : Long

    @Insert(entity = CuisineDbDTO::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertCuisine(cuisine: CuisineDbDTO) : Long

    @Insert(entity = CuisineDbDTO::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertCuisines(cuisines: List<CuisineDbDTO>) : List<Long>


    //TODO Improve
    @Transaction
    fun insertRecipe (recipe: Recipe) {
        insertCuisines(recipe.cuisines.map { CuisineDbDTO(cuisineId = null, cuisineName = it) })
        val recipeId = insertRecipe(recipe.fromDomainToDatabaseDTO())

        val listOfCuisineIds = mutableListOf<Long>()

        recipe.cuisines.forEach {
            listOfCuisineIds.add(findCuisineByName(it).cuisineId!!) //TODO Remove !!
        }

        listOfCuisineIds.forEach { cuisineId ->
            insertRecipeCuisineJoin(RecipeCuisineJoin(recipeId, cuisineId))
        }


    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertRecipeCuisineJoin(recipeCuisineJoin: RecipeCuisineJoin)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertRecipes(recipes: List<RecipeDbDTO>)



    @Update
    fun updateRecipe(recipe: RecipeDbDTO)




}