package com.diegomfv.splendidrecipesmvvm.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

//TODO See other options
class ListStringConverter {

    @TypeConverter
    fun fromList(cuisinesList: List<String?>?): String? {
        if (cuisinesList == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<String?>?>() {}.type
        return gson.toJson(cuisinesList, type)
    }

    @TypeConverter
    fun toList(cuisinesListString: String?): List<String>? {
        if (cuisinesListString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson<List<String>>(cuisinesListString, type)
    }
}