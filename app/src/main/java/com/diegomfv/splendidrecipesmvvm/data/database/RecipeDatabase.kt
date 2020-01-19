package com.diegomfv.splendidrecipesmvvm.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.diegomfv.splendidrecipesmvvm.data.database.model.join.RecipeCuisineJoin
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.CuisineDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.DishTypeDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.RecipeDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.RestrictionDbDTO

@Database(
    entities = [
        RecipeDbDTO::class,
        CuisineDbDTO::class,
        DishTypeDbDTO::class,
        RestrictionDbDTO::class,
        RecipeCuisineJoin::class
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