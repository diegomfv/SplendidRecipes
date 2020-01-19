package com.diegomfv.splendidrecipesmvvm.data.database.mappers


import com.diegomfv.splendidrecipesmvvm.data.model.dto.RecipeServerDTO
import com.diegomfv.domain.Recipe
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.CuisineDbDTO
import com.diegomfv.splendidrecipesmvvm.data.database.model.main.RecipeDbDTO

//fun RecipeServerDTO.toCuisineDbDTO () : CuisineDbDTO {
//    return CuisineDbDTO(
//        id = id ?: 0,
//        title = title ?: "null title",
//        cuisines = cuisines ?: listOf(),
//        imageUrl = image ?: "",
//        dishTypes = dishTypes ?: listOf(),
//        readyInMinutes = readyInMinutes ?: 0
//    )
//}



////TODO
//fun RecipeServerDTO.fromServerDTOToDomain () : Recipe {
//    return Recipe(
//        id = id ?: 0,
//        title = title ?: "null title",
//        cuisines = cuisines ?: listOf(),
//        imageUrl = image ?: "",
//        dishTypes = dishTypes ?: listOf(),
//        readyInMinutes = readyInMinutes ?: 0)
//}
//
//fun RecipeServerDTO.fromServerDTOToDatabaseDTO () : RecipeDbDTO {
//    return RecipeDbDTO(
//        id = id ?: 0,
//        title = title ?: "null title",
//        cuisines = cuisines ?: listOf(),
//        imageUrl = image ?: "",
//        dishTypes = dishTypes ?: listOf(),
//        readyInMinutes = readyInMinutes ?: 0
//    )
//}
//
//fun Recipe.fromDomainToDatabaseDTO () : RecipeDbDTO {
//    return RecipeDbDTO(
//        id = id,
//        title = title,
//        cuisines = cuisines,
//        imageUrl = imageUrl,
//        dishTypes = dishTypes,
//        readyInMinutes = readyInMinutes
//    )
//}
//
//fun RecipeDbDTO.fromDatabaseDTOToDomain () : Recipe {
//    return Recipe(
//        id = id,
//        title = title,
//        cuisines = cuisines,
//        imageUrl = imageUrl,
//        dishTypes = dishTypes,
//        readyInMinutes = readyInMinutes)
//}