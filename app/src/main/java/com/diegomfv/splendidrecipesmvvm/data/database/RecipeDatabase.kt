package com.diegomfv.splendidrecipesmvvm.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.diegomfv.splendidrecipesmvvm.data.database.model.entititiesjoin.RecipeCuisineAssoc
import com.diegomfv.splendidrecipesmvvm.data.database.model.entititiesjoin.RecipeDishTypeAssoc
import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.CuisineDb
import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.DishTypeDb
import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.RecipeDb

@Database(
    entities = [
        RecipeDb::class,
        CuisineDb::class,
        DishTypeDb::class,
        RecipeCuisineAssoc::class,
        RecipeDishTypeAssoc::class
    ],
    version = 1,
    exportSchema = false
)
abstract class RecipesDatabase : RoomDatabase() {

    companion object {
        fun build(context: Context) = Room.databaseBuilder(
            context,
            RecipesDatabase::class.java,
            "recipes-db"
        ).build()
    }

    abstract fun recipeDao(): RecipeDao
}