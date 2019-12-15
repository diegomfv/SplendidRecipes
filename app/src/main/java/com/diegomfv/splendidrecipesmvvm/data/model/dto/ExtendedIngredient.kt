package com.diegomfv.splendidrecipesmvvm.data.model.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ExtendedIngredient (
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
