package com.diegomfv.splendidrecipesmvvm.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.diegomfv.splendidrecipesmvvm.data.database.converter.ListStringConverter

@Database(entities = [RecipeDatabaseDTO::class], version = 1)
@TypeConverters(ListStringConverter::class)
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