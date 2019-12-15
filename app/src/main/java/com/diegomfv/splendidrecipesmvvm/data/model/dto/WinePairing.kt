package com.diegomfv.splendidrecipesmvvm.data.model.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WinePairing (
    @SerializedName("pairedWines") val pairedWines: List<Int>?, //TODO
    @SerializedName("pairingText") val pairingText: String?,
    @SerializedName("productMatches") val productMatches: List<Int>? //TODO
) : Parcelable