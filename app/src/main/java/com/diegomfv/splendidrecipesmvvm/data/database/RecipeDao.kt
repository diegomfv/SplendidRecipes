package com.diegomfv.splendidrecipesmvvm.data.database

import androidx.room.*
import com.diegomfv.splendidrecipesmvvm.data.database.constants.*

import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.RecipeDbTemp

@Dao
interface RecipeDao {

    @Query("SELECT COUNT($RECIPE_ID) FROM $RECIPE_TABLE_NAME")
    fun recipesCount(): Int


    @Query("SELECT * FROM $RECIPE_TABLE_NAME")
    fun getAllRecipes(): List<RecipeDbTemp>

    @Query("SELECT * FROM $RECIPE_TABLE_NAME WHERE $RECIPE_ID = :id")
    fun getRecipeById(id: Long): RecipeDbTemp


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertRecipes(recipes: List<RecipeDbTemp>)

    @Update
    fun updateRecipe(recipe: RecipeDbTemp)



//    @Query("SELECT * FROM $CUISINE_TABLE_NAME")
//    fun getAllCuisines(): List<CuisineDb>
//
//    @Query("SELECT * FROM $DISH_TYPE_TABLE_NAME")
//    fun getAllDishTypes(): List<DishTypeDb>
//
//
//
//    @Transaction
//    @Query("SELECT * FROM $RECIPE_CUISINE_TABLE_NAME")
//    fun getAllRecipeCuisineJoin(): List<RecipeCuisineAssoc>
//
//    @Transaction
//    @Query("SELECT * FROM $RECIPE_DISH_TYPE_TABLE_NAME")
//    fun getAllRecipeDishTypeJoin(): List<RecipeDishTypeAssoc>
//
//
//
//    @Transaction
//    @Query("SELECT * FROM $RECIPE_TABLE_NAME")
//    fun getRecipeCuisineAssoc(): RecipeJoin
//
//    @Transaction
//    @Query("SELECT * FROM $RECIPE_TABLE_NAME LIMIT 5")
//    fun getAllRecipeAssoc(): List<RecipeJoin>

//    @Query("SELECT * FROM $CUISINE_TABLE_NAME WHERE $CUISINE_ID = :id")
//    fun findCuisineById(id: Long): CuisineDb
//
//    @Query("SELECT * FROM $RECIPE_CUISINE_TABLE_NAME WHERE $RECIPE_ID = :id")
//    fun findRecipeWithCuisineById(id: Int): RecipeCuisineAssoc
//
//
//
//    @Query("SELECT * FROM $RECIPE_TABLE_NAME WHERE $RECIPE_NAME = :name")
//    fun findRecipeByName(name: String) : RecipeDb
//
//    @Query("SELECT * FROM $CUISINE_TABLE_NAME WHERE $CUISINE_NAME = :name")
//    fun findCuisineByName(name: String) : CuisineDb
//
//    @Query("SELECT * FROM $DISH_TYPE_TABLE_NAME WHERE $DISH_TYPE_NAME = :name")
//    fun findDishTypeByName(name: String) : DishTypeDb
//
//
//
//    @Query("SELECT COUNT($RECIPE_ID) FROM $RECIPE_TABLE_NAME")
//    fun recipesCount(): Int
//
//
//
//    @Insert(entity = RecipeDb::class, onConflict = OnConflictStrategy.IGNORE)
//    fun insertRecipe(recipe: RecipeDb) : Long
//
//    @Insert(entity = CuisineDb::class, onConflict = OnConflictStrategy.IGNORE)
//    fun insertCuisine(cuisine: CuisineDb) : Long
//
//    @Insert(entity = CuisineDb::class, onConflict = OnConflictStrategy.IGNORE)
//    fun insertCuisines(cuisines: List<CuisineDb>) : List<Long>
//
//    @Insert(entity = DishTypeDb::class, onConflict = OnConflictStrategy.IGNORE)
//    fun insertDishTypes(dishTypes: List<DishTypeDb>) : List<Long>
//
//
//
//    //TODO Improve
//    @Transaction
//    fun insertRecipe (recipe: Recipe) {
//
//        insertCuisines(recipe.cuisines.map { CuisineDb(cuisineId = null, cuisineName = it) })
//        insertDishTypes(recipe.dishTypes.map { DishTypeDb(dishTypeId = null, dishTypeName = it) })
//
//        val recipeId = insertRecipe(recipe.fromDomainToDatabaseDTO())
//        if (recipeId.notErrorOnQueryInsertion()) {
//
//            recipe.cuisines
//                .mapNotNull { findCuisineByName(it).cuisineId }
//                .forEach { cuisineId ->
//                    insertRecipeCuisineJoin(
//                        RecipeCuisineAssoc(
//                            recipeId,
//                            cuisineId
//                        )
//                    )
//                }
//
//            recipe.dishTypes
//                .mapNotNull { findDishTypeByName(it).dishTypeId }
//                .forEach { dishTypeId ->
//                    insertRecipeDishTypeJoin(
//                        RecipeDishTypeAssoc(
//                            recipeId,
//                            dishTypeId
//                        )
//                    )
//                }
//        }
//    }

//    @Insert(entity = RecipeCuisineAssoc::class, onConflict = OnConflictStrategy.IGNORE)
//    fun insertRecipeCuisineJoin(recipeCuisineAssoc: RecipeCuisineAssoc)
//
//    @Insert(entity = RecipeDishTypeAssoc::class,onConflict = OnConflictStrategy.IGNORE)
//    fun insertRecipeDishTypeJoin(recipeDishTypeAssoc: RecipeDishTypeAssoc)
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun insertRecipes(recipes: List<Recipe>)
//
//
//
//    @Update
//    fun updateRecipe(recipe: RecipeDb)

}