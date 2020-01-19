package com.diegomfv.splendidrecipesmvvm.data.model.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RandomRecipesResult(
    @SerializedName("recipes") val recipeServerDTOS: List<RecipeServerDTO>?
) : Parcelable


@Parcelize
data class RecipeServerDTO(
    @SerializedName("id") val id: Long?,
    @SerializedName("title") val title: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("imageType") val imageType: String?,
    @SerializedName("servings") val servings: Int?,
    @SerializedName("readyInMinutes") val readyInMinutes: Int?,
    @SerializedName("license") val license: String?,
    @SerializedName("sourceName") val sourceName: String?,
    @SerializedName("sourceUrl") val sourceUrl: String?,
    @SerializedName("spoonacularSourceUrl") val spoonacularSourceUrl: String?,
    @SerializedName("aggregateLikes") val aggregateLikes: Int?,
    @SerializedName("healthScore") val healthScore: Double?,
    @SerializedName("spoonacularScore") val spoonacularScore: Double?,
    @SerializedName("pricePerServing") val pricePerServing: Double?,
    @SerializedName("analyzedInstructions") val analyzedInstructions: List<AnalyzedInstruction>?,
    @SerializedName("cheap") val cheap: Boolean?,
    @SerializedName("creditsText") val creditsText: String?,
    @SerializedName("cuisines") val cuisines: List<String>?,
    @SerializedName("dairyFree") val dairyFree: Boolean?,
    @SerializedName("diets") val diets: List<String>?,
    @SerializedName("gaps") val gaps: String?,
    @SerializedName("glutenFree") val glutenFree: Boolean?,
    @SerializedName("instructions") val instructions: String?,
    @SerializedName("ketogenic") val ketogenic: Boolean?,
    @SerializedName("lowFodmap") val lowFodmap: Boolean?,
    @SerializedName("occasions") val occasions: List<String>?,
    @SerializedName("sustainable") val sustainable: Boolean?,
    @SerializedName("vegan") val vegan: Boolean?,
    @SerializedName("vegetarian") val vegetarian: Boolean?,
    @SerializedName("veryHealthy") val veryHealthy: Boolean?,
    @SerializedName("veryPopular") val veryPopular: Boolean?,
    @SerializedName("whole30") val whole30: Boolean?,
    @SerializedName("weightWatcherSmartPoints") val weightWatcherSmartPoints: Int?,
    @SerializedName("dishTypes") val dishTypes: List<String>?,
    @SerializedName("extendedIngredients") val extendedIngredients: List<ExtendedIngredient>?,
    @SerializedName("winePairing") val winePairing: WinePairing?
) : Parcelable


@Parcelize
data class AnalyzedInstruction(
    @SerializedName("name") val name: String?,
    @SerializedName("steps") val steps: List<Step>?
) : Parcelable


@Parcelize
data class Step(
    @SerializedName("equipment") val equipment: List<Equipment>?,
    @SerializedName("ingredients") val ingredients: List<Ingredient>?,
    @SerializedName("length") val length: Length?,
    @SerializedName("number") val number: Int?,
    @SerializedName("step") val step: String
) : Parcelable


@Parcelize
data class Ingredient(
    @SerializedName("id") val id: Int?,
    @SerializedName("image") val image: String?,
    @SerializedName("name") val name: String?
) : Parcelable


@Parcelize
data class Length(
    @SerializedName("number") val number: Int?,
    @SerializedName("unit") val unit: String?
) : Parcelable


@Parcelize
data class ExtendedIngredient(
    @SerializedName("aisle") val aisle: String?,
    @SerializedName("amount") val amount: Double?,
    @SerializedName("consitency") val consitency: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("image") val image: String?,
    @SerializedName("measures") val measures: Measures?,
    @SerializedName("meta") val meta: List<String>?,
    @SerializedName("metaInformation") val metaInformation: List<String>?,
    @SerializedName("name") val name: String?,
    @SerializedName("original") val original: String?,
    @SerializedName("originalName") val originalName: String?,
    @SerializedName("originalString") val originalString: String?,
    @SerializedName("unit") val unit: String?
) : Parcelable


@Parcelize
data class Measures(
    @SerializedName("metric") val metric: Metric?,
    @SerializedName("us") val us: Us?
) : Parcelable


@Parcelize
data class Metric(
    @SerializedName("amount") val amount: Double?,
    @SerializedName("unitLong") val unitLong: String?,
    @SerializedName("unitShort") val unitShort: String?
) : Parcelable


@Parcelize
data class Us(
    @SerializedName("amount") val amount: Double?,
    @SerializedName("unitLong") val unitLong: String?,
    @SerializedName("unitShort") val unitShort: String?
) : Parcelable


@Parcelize
data class WinePairing(
    @SerializedName("pairedWines") val pairedWines: List<String>?,
    @SerializedName("pairingText") val pairingText: String?,
    @SerializedName("productMatches") val productMatches: List<ProductMatches>?
) : Parcelable


@Parcelize
data class Equipment(
    @SerializedName("id") val id: Int?,
    @SerializedName("image") val image: String?,
    @SerializedName("name") val name: String?
) : Parcelable


@Parcelize
data class ProductMatches(
    @SerializedName("averageRating") val averageRating: Double?,
    @SerializedName("description") val description: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("imageUrl") val imageUrl: String?,
    @SerializedName("link") val link: String?,
    @SerializedName("price") val price: String?,
    @SerializedName("ratingCount") val ratingCount: Double?,
    @SerializedName("score") val score: Double?,
    @SerializedName("title") val title: String
) : Parcelable