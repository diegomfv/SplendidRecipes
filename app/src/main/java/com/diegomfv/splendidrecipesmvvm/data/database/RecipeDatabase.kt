package com.diegomfv.splendidrecipesmvvm.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.diegomfv.splendidrecipesmvvm.data.model.dto.Recipe

@Database(entities = [Recipe::class], version = 1)
abstract class RecipeDatabase : RoomDatabase() {
//
//    companion object {
//        fun build(context: Context) = Room.databaseBuilder(
//            context,
//            RecipeDatabase::class.java,
//            "movie-db"
//        ).build()
//    }
//
//    abstract fun movieDao(): RecipeDao
}