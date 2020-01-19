package com.diegomfv.splendidrecipesmvvm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.diegomfv.domain.Recipe
import com.diegomfv.splendidrecipesmvvm.ui.common.Event
import com.diegomfv.splendidrecipesmvvm.ui.common.ScopedViewModel
import com.diegomfv.splendidrecipesmvvm.ui.common.logSth
import kotlinx.coroutines.CoroutineDispatcher

class DetailActivityViewModel(
    uiDispatcher: CoroutineDispatcher
) : ScopedViewModel(uiDispatcher) {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) {
                logSth("_model triggered //")
            }
            return _model
        }

    val event = MutableLiveData<Event<EventModel>>()

    fun onFavouriteClicked() {

    }

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val recipes: List<Recipe>) : UiModel()
        data class Error(val throwable: Throwable) : UiModel()
    }

    sealed class EventModel {
        data class Navigation(val recipe: Recipe) : EventModel()
        object RequestLocationPermission : EventModel()
    }

}