package com.diegomfv.splendidrecipesmvvm.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.diegomfv.data.common.Response
import com.diegomfv.splendidrecipesmvvm.R
import com.diegomfv.splendidrecipesmvvm.ui.common.startActivity
import com.diegomfv.splendidrecipesmvvm.ui.common.toast
import com.diegomfv.splendidrecipesmvvm.ui.detail.DetailActivity
import com.diegomfv.usecase.GetRandomRecipesUseCase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel: MainActivityViewModel by currentScope.viewModel(this)
    lateinit var adapter: RecipesAdapter

    private val getRandomRecipesUseCase: GetRandomRecipesUseCase by currentScope.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = RecipesAdapter (mainActivityViewModel::onRecipeClicked)
        recycler_view.adapter = adapter

        mainActivityViewModel.model.observe(this, Observer(::updateUI))
        mainActivityViewModel.event.observe(this, Observer { it.getContentIfNotHandled()?.let { event -> triggerEvent(event) } })

        button.setOnClickListener {
            mainActivityViewModel.refreshAdapter()
        }

        GlobalScope.launch {
            val response = getRandomRecipesUseCase.invoke(10)
            when (response) {
                is Response.Success -> {
                    response.result.forEach { println(it.toString()) }
                }
            }
        }
    }

    private fun updateUI (uiModel: MainActivityViewModel.UiModel) {

        when (uiModel) {
            MainActivityViewModel.UiModel.Loading -> toast("Loading...") //TODO
            is MainActivityViewModel.UiModel.Content -> adapter.recipes = uiModel.recipes
            is MainActivityViewModel.UiModel.Error -> toast(uiModel.throwable.message ?: "Null Error") //TODO Add Error mapper
        }
    }

    private fun triggerEvent (eventModel: MainActivityViewModel.EventModel) {
        when (eventModel) {
            is MainActivityViewModel.EventModel.Navigation -> startActivity<DetailActivity> { putExtra(DetailActivity.KEY, eventModel.recipe.id) }
            MainActivityViewModel.EventModel.RequestLocationPermission -> toast("Request location permissions")
        }
    }

}