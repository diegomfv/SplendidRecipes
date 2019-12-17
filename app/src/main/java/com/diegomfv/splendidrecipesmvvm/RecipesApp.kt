package com.diegomfv.splendidrecipesmvvm

import android.app.Application
import timber.log.Timber

class RecipesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
        AppProvider.init(this)
        if (BuildConfig.DEBUG) { Timber.plant(Timber.DebugTree()) }
    }
}