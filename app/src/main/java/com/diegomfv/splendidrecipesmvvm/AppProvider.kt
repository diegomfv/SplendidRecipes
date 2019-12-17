package com.diegomfv.splendidrecipesmvvm

object AppProvider {

    lateinit var app: RecipesApp
    private set

    fun init (app: RecipesApp) { this.app = app }

}