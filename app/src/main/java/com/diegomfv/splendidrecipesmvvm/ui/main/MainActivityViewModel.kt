package com.diegomfv.splendidrecipesmvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.diegomfv.domain.Recipe
import com.diegomfv.splendidrecipesmvvm.ui.common.ScopedViewModel
import com.diegomfv.usecase.GetRandomRecipesUseCase
import com.diegomfv.data.common.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivityViewModel (
    private val getRandomRecipesUseCase: GetRandomRecipesUseCase,
    uiDispatcher: CoroutineDispatcher
) : ScopedViewModel(uiDispatcher) {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) {
                refreshAdapter()
            }
            return _model
        }

    fun onRecipeClicked(recipe: Recipe) {
        _model.value = UiModel.Navigation(recipe)
    }

    //TODO Dummy for the moment
    fun refreshAdapter() {
        GlobalScope.launch {
            val randomRecipes = getRandomRecipesUseCase.invoke()
            when (randomRecipes) {
                is Response.Success -> _model.postValue(UiModel.Content(randomRecipes.result))
                is Response.Failure -> _model.postValue(UiModel.Error(randomRecipes.throwable))
            }
        }
    }

//    override fun onCleared() {
//        super.onCleared()
//    }

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val recipes: List<Recipe>) : UiModel()
        data class Error(val throwable : Throwable) : UiModel()
        data class Navigation(val recipe: Recipe) : UiModel()
        object RequestLocationPermission : UiModel()
    }
}