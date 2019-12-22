package com.diegomfv.domain

data class Recipe (
    val id: Int,
    val title: String,
    val cuisines: List<String>,
    val imageUrl: String,
    val dishTypes: List<String>,
    val readyInMinutes: Int
)