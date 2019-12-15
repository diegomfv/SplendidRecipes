package com.diegomfv.splendidrecipesmvvm.data.model.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Measures (
    @SerializedName("metric") val metric: Metric?,
    @SerializedName("us") val us: Us?
) : Parcelable