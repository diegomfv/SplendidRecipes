package com.diegomfv.splendidrecipesmvvm.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.diegomfv.splendidrecipesmvvm.R
import com.diegomfv.splendidrecipesmvvm.ui.common.startActivity
import com.diegomfv.splendidrecipesmvvm.ui.common.toast
import com.diegomfv.splendidrecipesmvvm.ui.detail.DetailActivity
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
            is MainActivityViewModel.UiModel.Error -> toast(uiModel.throwable.message ?: "Null Error") //TODO Add Error mapper
            is MainActivityViewModel.UiModel.Navigation -> startActivity<DetailActivity> {  }
        }
    }

}