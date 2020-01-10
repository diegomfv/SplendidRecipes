package com.diegomfv.splendidrecipesmvvm.data

import com.diegomfv.splendidrecipesmvvm.data.model.dto.Recipe as RecipeDTO
import com.diegomfv.domain.Recipe as RecipeDomain
import com.diegomfv.splendidrecipesmvvm.data.database.Recipe as RecipeDatabase

//TODO
fun RecipeDTO.fromDTOToDomain () : RecipeDomain {
    return RecipeDomain(
        id = id ?: 0,
        title = title ?: "null title",
        cuisines = cuisines ?: listOf(),
        imageUrl = image ?: "",
        dishTypes = dishTypes ?: listOf(),
        readyInMinutes = readyInMinutes ?: 0)
}

fun RecipeDTO.fromDTOToDatabase () : RecipeDatabase {
    return RecipeDatabase(
        id = id ?: 0,
        title = title ?: "null title",
        cuisines = cuisines ?: listOf(),
        imageUrl = image ?: "",
        dishTypes = dishTypes ?: listOf(),
        readyInMinutes = readyInMinutes ?: 0)
}

fun RecipeDomain.fromDomainToDTO () : RecipeDatabase {
    return RecipeDatabase(
        id = id,
        title = title,
        cuisines = cuisines,
        imageUrl = imageUrl,
        dishTypes = dishTypes,
        readyInMinutes = readyInMinutes)
}

fun RecipeDomain.fromDomainToDatabase () : RecipeDatabase {
    return RecipeDatabase(
        id = id,
        title = title,
        cuisines = cuisines,
        imageUrl = imageUrl,
        dishTypes = dishTypes,
        readyInMinutes = readyInMinutes)
}

fun RecipeDatabase.fromDatabaseToDomain () : RecipeDomain {
    return RecipeDomain(
        id = id,
        title = title,
        cuisines = cuisines,
        imageUrl = imageUrl,
        dishTypes = dishTypes,
        readyInMinutes = readyInMinutes)
}