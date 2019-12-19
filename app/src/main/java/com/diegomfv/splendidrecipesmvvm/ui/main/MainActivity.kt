package com.diegomfv.splendidrecipesmvvm.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.diegomfv.splendidrecipesmvvm.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel: MainActivityViewModel by currentScope.viewModel(this)
    lateinit var adapter: RecipesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = RecipesAdapter (mainActivityViewModel::onRecipeClicked)
        recycler_view.adapter = adapter
        mainActivityViewModel.model.observe(this, Observer(::updateUI))


        button.setOnClickListener {
            mainActivityViewModel.refreshAdapter()
        }

    }

    private fun updateUI (uiModel: MainActivityViewModel.UiModel) {

        when (uiModel) {
            is MainActivityViewModel.UiModel.Content -> adapter.recipes = uiModel.recipes
        }

    }

}