package com.diegomfv.splendidrecipesmvvm.ui.detail

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diegomfv.splendidrecipesmvvm.RecipesApp
import com.diegomfv.splendidrecipesmvvm.data.model.dto.Recipe
import com.diegomfv.splendidrecipesmvvm.ui.common.logSth

class DetailActivityViewModel() : ViewModel() {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
           if (_model.value == null) { logSth("_model triggered //") }
            return _model
        }

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val recipes: List<Recipe>) : UiModel()
        data class Navigation(val recipe: Recipe) : UiModel()
        object RequestLocationPermission : UiModel()
    }
//
//    private fun refresh() {
//        _model.value = UiModel.RequestLocationPermission
//    }
//
//
//    fun onRecipeSelected(recipe: Recipe) {
//        _model.value = UiModel.Navigation(recipe)
//    }

    override fun onCleared() {
        super.onCleared()
    }
}