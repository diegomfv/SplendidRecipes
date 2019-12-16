package com.diegomfv.splendidrecipesmvvm.ui.main

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.diegomfv.splendidrecipesmvvm.RecipesApp
import com.diegomfv.splendidrecipesmvvm.data.model.dto.Recipe


class MainActivityViewModel(val app: RecipesApp) : AndroidViewModel (app) {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) refresh()
            return _model
        }

    private fun refresh() {
        _model.value = UiModel.RequestLocationPermission
    }
//
//    fun onCoarsePermissionRequested() {}
//
//    fun onMovieClicked(recipe: Recipe) {
//        _model.value = UiModel.Navigation(recipe)
//    }

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