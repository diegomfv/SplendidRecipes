package com.diegomfv.splendidrecipesmvvm.ui.detail

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.diegomfv.splendidrecipesmvvm.R
import com.diegomfv.splendidrecipesmvvm.ui.common.startActivity
import com.diegomfv.splendidrecipesmvvm.ui.common.toast
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY = "key"
    }

    private val viewModel: DetailActivityViewModel by currentScope.viewModel(this) {
        parametersOf(intent.getIntExtra(KEY, -1))
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_detail)

        viewModel.model.observe(this, Observer(::updateUi))
        viewModel.event.observe(this, Observer { it.getContentIfNotHandled()?.let { event -> triggerEvent(event) } })

    }


    private fun updateUi (uiModel: DetailActivityViewModel.UiModel) {

        when (uiModel) {
            DetailActivityViewModel.UiModel.Loading -> toast("Loading...") //TODO
            is DetailActivityViewModel.UiModel.Content -> toast("Show detail...") //TODO
            is DetailActivityViewModel.UiModel.Error -> toast(uiModel.throwable.message ?: "Null Error") //TODO Add Error mapper
        }
    }

    private fun triggerEvent (eventModel: DetailActivityViewModel.EventModel) {
        when (eventModel) {
            is DetailActivityViewModel.EventModel.Navigation -> startActivity<DetailActivity> {  }
            DetailActivityViewModel.EventModel.RequestLocationPermission -> toast("Request location permissions")
        }
    }

}