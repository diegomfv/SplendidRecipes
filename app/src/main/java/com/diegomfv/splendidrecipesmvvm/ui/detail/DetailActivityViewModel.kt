package com.diegomfv.splendidrecipesmvvm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.diegomfv.splendidrecipesmvvm.data.model.dto.RecipeServerDTO
import com.diegomfv.splendidrecipesmvvm.ui.common.ScopedViewModel
import com.diegomfv.splendidrecipesmvvm.ui.common.logSth
import kotlinx.coroutines.CoroutineDispatcher

class DetailActivityViewModel(
    uiDispatcher: CoroutineDispatcher
) : ScopedViewModel(uiDispatcher) {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
           if (_model.value == null) { logSth("_model triggered //") }
            return _model
        }

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val recipeServerDTOS: List<RecipeServerDTO>) : UiModel()
        data class Navigation(val recipeServerDTO: RecipeServerDTO) : UiModel()
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


    fun onFavouriteClicked () {



    }

    override fun onCleared() {
        super.onCleared()
    }
}