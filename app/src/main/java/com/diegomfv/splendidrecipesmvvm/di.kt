package com.diegomfv.splendidrecipesmvvm

import android.app.Application
import com.diegomfv.data.repository.RecipesRepository
import com.diegomfv.data.source.RemoteDataSource
import com.diegomfv.splendidrecipesmvvm.data.server.RecipeRemoteDataSource
import com.diegomfv.splendidrecipesmvvm.data.server.RecipeRetrofit
import com.diegomfv.splendidrecipesmvvm.ui.detail.DetailActivity
import com.diegomfv.splendidrecipesmvvm.ui.detail.DetailActivityViewModel
import com.diegomfv.splendidrecipesmvvm.ui.main.MainActivity
import com.diegomfv.splendidrecipesmvvm.ui.main.MainActivityViewModel
import com.diegomfv.usecase.GetRandomRecipesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(listOf(appModule, dataModule, usecaseModule, scopesModule))
    }
}

private val appModule = module {
    single(named("apiKey")) { androidApplication().getString(R.string.api_key) }
    single(named("baseUrl")) { "https://api.spoonacular.com/" }
//    single { RecipesDatabase.build(get()) }
//    factory<LocalDataSource> { RoomDataSource(get()) }
    factory<RemoteDataSource> { RecipeRemoteDataSource(get()) }
//    factory<LocationDataSource> { PlayServicesLocationDataSource(get()) }
//    factory<PermissionChecker> { AndroidPermissionChecker(get()) }
    single<CoroutineDispatcher> { Dispatchers.Main }
    single { RecipeRetrofit(get(named("baseUrl"))) }
}

val dataModule = module {
//    factory { RegionRepository(get(), get()) }
    factory { RecipesRepository(get(), get(named("apiKey"))) }
}

val usecaseModule = module {
    factory { GetRandomRecipesUseCase(get()) }
}

private val scopesModule = module {
    scope(named<MainActivity>()) {
        viewModel { MainActivityViewModel(get()) }
//        scoped { GetPopularMovies(get()) }
    }

    scope(named<DetailActivity>()) {
        viewModel { DetailActivityViewModel() }
//        scoped { FindMovieById(get()) }
//        scoped { ToggleMovieFavorite(get()) }
    }
}