package com.diegomfv.splendidrecipesmvvm.data.database.mappers

import com.diegomfv.splendidrecipesmvvm.data.model.dto.RecipeServerDTO
import com.diegomfv.domain.Recipe
import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.RecipeDbTemp

//TODO
fun RecipeServerDTO.toRecipe () : Recipe {
    return Recipe(
        id = id ?: 0,
        title = title ?: "null title",
        cuisines = cuisines ?: listOf(),
        imageUrl = image ?: "",
        dishTypes = dishTypes ?: listOf(),
        readyInMinutes = readyInMinutes ?: 0,
        ingredients = listOf()
    )
}

fun RecipeServerDTO.toRecipeDbTemp () : RecipeDbTemp {
    return RecipeDbTemp(
        id = id ?: 0,
        title = title ?: "null title",
        cuisines = cuisines ?: listOf(),
        imageUrl = image ?: "",
        dishTypes = dishTypes ?: listOf(),
        readyInMinutes = readyInMinutes ?: 0,
        ingredients = listOf(),
        favourite = false
    )
}

fun Recipe.toRecipeDbTemp () : RecipeDbTemp {
    return RecipeDbTemp(
        id = id,
        title = title,
        cuisines = cuisines,
        imageUrl = imageUrl,
        dishTypes = dishTypes,
        readyInMinutes = readyInMinutes,
        ingredients = listOf(),
        favourite = false
    )
}

fun RecipeDbTemp.toRecipe () : Recipe {
    return Recipe(
        id = id,
        title = title,
        cuisines = cuisines,
        imageUrl = imageUrl,
        dishTypes = dishTypes,
        readyInMinutes = readyInMinutes,
        ingredients = listOf()
    )
}

//fun RecipeJoin.toDomain () : Recipe {
//    return Recipe(
//        id = recipe.id,
//        title = recipe.recipeName,
//        cuisines = cuisines.map { it.cuisineName },
//        imageUrl = recipe.imageUrl,
//        dishTypes = dishTypes.map { it.dishTypeName },
//        readyInMinutes = recipe.readyInMinutes,
//        ingredients = listOf()
//    )
//}