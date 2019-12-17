package com.diegomfv.splendidrecipesmvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diegomfv.splendidrecipesmvvm.data.model.dto.Recipe
import com.diegomfv.splendidrecipesmvvm.ui.common.logSth

class MainActivityViewModel : ViewModel() {

    val dummyList by lazy {
        listOf(
            Recipe.withId(1),
            Recipe.withId(2),
            Recipe.withId(3),
            Recipe.withId(4),
            Recipe.withId(5)
        )
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) {
                logSth("_model triggered //")
            }
            return _model
        }

    fun onRecipeClicked(recipe: Recipe) {
//        _model.value = UiModel.Navigation(recipe)
        refreshAdapter()
    }

    //TODO Dummy for the moment
    fun refreshAdapter() {
        _model.value = UiModel.Content(dummyList)
    }

//    override fun onCleared() {
//        super.onCleared()
//    }

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val recipes: List<Recipe>) : UiModel()
        data class Navigation(val recipe: Recipe) : UiModel()
        object RequestLocationPermission : UiModel()
    }
}