package com.diegomfv.splendidrecipesmvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diegomfv.domain.Recipe
import com.diegomfv.usecase.GetRandomRecipesUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivityViewModel (
    private val getRandomRecipesUseCase: GetRandomRecipesUseCase
) : ViewModel() {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) {
                refreshAdapter()
            }
            return _model
        }

    fun onRecipeClicked(recipe: Recipe) {
//        _model.value = UiModel.Navigation(recipe)
        refreshAdapter()
    }

    //TODO Dummy for the moment
    fun refreshAdapter() {
        GlobalScope.launch {
            _model.postValue(UiModel.Content(getRandomRecipesUseCase.invoke()))
        }
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