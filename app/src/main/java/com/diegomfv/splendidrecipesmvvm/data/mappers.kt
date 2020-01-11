package com.diegomfv.splendidrecipesmvvm.data

import com.diegomfv.splendidrecipesmvvm.data.model.dto.RecipeServerDTO
import com.diegomfv.domain.Recipe
import com.diegomfv.splendidrecipesmvvm.data.database.RecipeDatabaseDTO

//TODO
fun RecipeServerDTO.fromServerDTOToDomain () : Recipe {
    return Recipe(
        id = id ?: 0,
        title = title ?: "null title",
        cuisines = cuisines ?: listOf(),
        imageUrl = image ?: "",
        dishTypes = dishTypes ?: listOf(),
        readyInMinutes = readyInMinutes ?: 0)
}

fun RecipeServerDTO.fromServerDTOToDatabaseDTO () : RecipeDatabaseDTO {
    return RecipeDatabaseDTO(
        id = id ?: 0,
        title = title ?: "null title",
        cuisines = cuisines ?: listOf(),
        imageUrl = image ?: "",
        dishTypes = dishTypes ?: listOf(),
        readyInMinutes = readyInMinutes ?: 0)
}

fun Recipe.fromDomainToDatabaseDTO () : RecipeDatabaseDTO {
    return RecipeDatabaseDTO(
        id = id,
        title = title,
        cuisines = cuisines,
        imageUrl = imageUrl,
        dishTypes = dishTypes,
        readyInMinutes = readyInMinutes)
}

fun RecipeDatabaseDTO.fromDatabaseDTOToDomain () : Recipe {
    return Recipe(
        id = id,
        title = title,
        cuisines = cuisines,
        imageUrl = imageUrl,
        dishTypes = dishTypes,
        readyInMinutes = readyInMinutes)
}