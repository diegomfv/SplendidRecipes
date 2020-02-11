package com.diegomfv.splendidrecipesmvvm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.diegomfv.domain.Recipe
import com.diegomfv.splendidrecipesmvvm.ui.common.Event
import com.diegomfv.splendidrecipesmvvm.ui.common.ScopedViewModel
import com.diegomfv.usecase.GetRecipeByIdUseCase
import com.diegomfv.usecase.UpdateFavouriteUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailActivityViewModel(
    private val recipeId: Long,
    private val getRecipeByIdUseCase: GetRecipeByIdUseCase,
    private val updateFavouriteUseCase: UpdateFavouriteUseCase,
    uiDispatcher: CoroutineDispatcher
) : ScopedViewModel(uiDispatcher) {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) {
                getRecipe(recipeId)
            }
            return _model
        }

    val event = MutableLiveData<Event<EventModel>>()

    fun onFavouriteClicked(favourite: Boolean) {
        GlobalScope.launch {
            updateFavouriteUseCase.invoke(recipeId, favourite)
        }
    }

    fun getRecipe(recipeId: Long) {
        GlobalScope.launch {
            val recipe = getRecipeByIdUseCase.invoke(recipeId)
            _model.postValue(UiModel.Content(recipe))
        }
    }

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val recipe: Recipe) : UiModel()
        data class Error(val throwable: Throwable) : UiModel()
    }

    sealed class EventModel {
        data class Navigation(val recipe: Recipe) : EventModel()
        object RequestLocationPermission : EventModel()
    }

}