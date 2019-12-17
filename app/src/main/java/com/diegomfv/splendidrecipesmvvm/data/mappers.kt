package com.diegomfv.splendidrecipesmvvm.data

import com.diegomfv.splendidrecipesmvvm.data.model.dto.Recipe as RecipeDTO
import com.diegomfv.domain.Recipe as RecipeDomain

//TODO
fun RecipeDTO.fromDTOToDomain () : RecipeDomain {
    return RecipeDomain(
        this.title ?: "null title"
    )

}