package com.diegomfv.splendidrecipesmvvm.ui.detail

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.diegomfv.splendidrecipesmvvm.R
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailActivity : AppCompatActivity() {

    companion object {
        const val argument = "argument"
    }

    private val viewModel: DetailActivityViewModel by currentScope.viewModel(this) {
        parametersOf(intent.getIntExtra(argument, -1))
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_detail)

//        viewModel.model.observe(this, Observer(::updateUi))
    }

}