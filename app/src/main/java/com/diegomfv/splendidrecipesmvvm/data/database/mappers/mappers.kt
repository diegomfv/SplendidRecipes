package com.diegomfv.splendidrecipesmvvm.data.database.mappers

import com.diegomfv.splendidrecipesmvvm.data.model.dto.RecipeServerDTO
import com.diegomfv.domain.Recipe
import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.RecipeDb

//TODO
fun RecipeServerDTO.fromServerDTOToDomain () : Recipe {
    return Recipe(
        id = id ?: 0,
        title = title ?: "null title",
        cuisines = cuisines ?: listOf(), //TODO
        imageUrl = image ?: "",
        dishTypes = dishTypes ?: listOf(), //TODO
        readyInMinutes = readyInMinutes ?: 0,
        ingredients = listOf() //TODO
    )
}

fun RecipeServerDTO.fromServerDTOToDatabaseDTO () : RecipeDb {
    return RecipeDb(
        id = id ?: 0,
        recipeName = title ?: "null title",
//        cuisines = cuisines ?: listOf(),
        imageUrl = image ?: "",
//        dishTypes = dishTypes ?: listOf(),
        readyInMinutes = readyInMinutes ?: 0
    )
}

fun Recipe.fromDomainToDatabaseDTO () : RecipeDb {
    return RecipeDb(
        id = id,
        recipeName = title,
//        cuisines = cuisines,
        imageUrl = imageUrl,
//        dishTypes = dishTypes,
        readyInMinutes = readyInMinutes
    )
}

fun RecipeDb.fromDatabaseDTOToDomain () : Recipe {
    return Recipe(
        id = id,
        title = recipeName,
        cuisines = listOf(), //TODO
        imageUrl = imageUrl,
        dishTypes = listOf(), //TODO
        readyInMinutes = readyInMinutes,
        ingredients = listOf() //TODO
    )
}