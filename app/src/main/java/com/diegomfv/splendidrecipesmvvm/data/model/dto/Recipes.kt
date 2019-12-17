package com.diegomfv.splendidrecipesmvvm.data.model.dto

import com.google.gson.annotations.SerializedName

data class Recipes (
    @SerializedName("recipes") val recipes: List<Recipe>?
)