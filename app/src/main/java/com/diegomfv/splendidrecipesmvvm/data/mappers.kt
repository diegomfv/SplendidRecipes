package com.diegomfv.splendidrecipesmvvm.data

import com.diegomfv.splendidrecipesmvvm.data.model.dto.Recipe as RecipeDTO
import com.diegomfv.domain.Recipe as RecipeDomain

//TODO
fun RecipeDTO.fromDTOToDomain () : RecipeDomain {
    return RecipeDomain(
        id = id ?: 0,
        title = title ?: "null title",
        cuisines = cuisines ?: listOf(),
        imageUrl = image ?: "",
        dishTypes = dishTypes ?: listOf(),
        readyInMinutes = readyInMinutes ?: 0
    )

}