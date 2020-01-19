package com.diegomfv.splendidrecipesmvvm.data.database

import androidx.room.*
import com.diegomfv.domain.Recipe
import com.diegomfv.splendidrecipesmvvm.data.database.constants.*
import com.diegomfv.splendidrecipesmvvm.data.database.mappers.fromDomainToDatabaseDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.join.entitities.RecipeCuisineJoin
import com.diegomfv.splendidrecipesmvvm.data.database.model.join.entitities.RecipeDishTypeJoin
import com.diegomfv.splendidrecipesmvvm.data.database.model.join.model.RecipeAssoc
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.CuisineDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.DishTypeDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.RecipeDbDTO

@Dao
interface RecipeDao {

    @Query("SELECT * FROM $RECIPE_TABLE_NAME")
    fun getAllRecipes(): List<RecipeDbDTO>

    @Query("SELECT * FROM $CUISINE_TABLE_NAME")
    fun getAllCuisines(): List<CuisineDbDTO>

    @Query("SELECT * FROM $DISH_TYPE_TABLE_NAME")
    fun getAllDishTypes(): List<DishTypeDbDTO>



    @Transaction
    @Query("SELECT * FROM $RECIPE_CUISINE_TABLE_NAME")
    fun getAllRecipeCuisineJoin(): List<RecipeCuisineJoin>

    @Transaction
    @Query("SELECT * FROM $RECIPE_DISH_TYPE_TABLE_NAME")
    fun getAllRecipeDishTypeJoin(): List<RecipeDishTypeJoin>



    @Transaction
    @Query("SELECT * FROM $RECIPE_TABLE_NAME")
    fun getRecipeCuisineAssoc(): RecipeAssoc

    @Transaction
    @Query("SELECT * FROM $RECIPE_TABLE_NAME")
    fun getAllRecipeAssoc(): List<RecipeAssoc>



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

    @Query("SELECT * FROM $DISH_TYPE_TABLE_NAME WHERE $DISH_TYPE_NAME = :name")
    fun findDishTypeByName(name: String) : DishTypeDbDTO



    @Query("SELECT COUNT($RECIPE_ID) FROM $RECIPE_TABLE_NAME")
    fun recipesCount(): Int



    @Insert(entity = RecipeDbDTO::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertRecipe(recipe: RecipeDbDTO) : Long

    @Insert(entity = CuisineDbDTO::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertCuisine(cuisine: CuisineDbDTO) : Long

    @Insert(entity = CuisineDbDTO::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertCuisines(cuisines: List<CuisineDbDTO>) : List<Long>

    @Insert(entity = DishTypeDbDTO::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertDishTypes(dishTypes: List<DishTypeDbDTO>) : List<Long>



    //TODO Improve
    @Transaction
    fun insertRecipe (recipe: Recipe) {

        insertCuisines(recipe.cuisines.map { CuisineDbDTO(cuisineId = null, cuisineName = it) })
        insertDishTypes(recipe.dishTypes.map { DishTypeDbDTO(dishTypeId = null, dishTypeName = it) })

        val recipeId = insertRecipe(recipe.fromDomainToDatabaseDTO())
        if (recipeId.notErrorOnQueryInsertion()) {

            recipe.cuisines
                .mapNotNull { findCuisineByName(it).cuisineId }
                .forEach { cuisineId ->
                    insertRecipeCuisineJoin(
                        RecipeCuisineJoin(
                            recipeId,
                            cuisineId
                        )
                    )
                }

            recipe.dishTypes
                .mapNotNull { findDishTypeByName(it).dishTypeId }
                .forEach { dishTypeId ->
                    insertRecipeDishTypeJoin(
                        RecipeDishTypeJoin(
                            recipeId,
                            dishTypeId
                        )
                    )
                }
        }
    }

    @Insert(entity = RecipeCuisineJoin::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertRecipeCuisineJoin(recipeCuisineJoin: RecipeCuisineJoin)

    @Insert(entity = RecipeDishTypeJoin::class,onConflict = OnConflictStrategy.IGNORE)
    fun insertRecipeDishTypeJoin(recipeDishTypeJoin: RecipeDishTypeJoin)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertRecipes(recipes: List<RecipeDbDTO>)



    @Update
    fun updateRecipe(recipe: RecipeDbDTO)

}

fun Long.notErrorOnQueryInsertion () = this != -1L