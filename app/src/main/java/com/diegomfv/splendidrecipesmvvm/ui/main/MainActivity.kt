package com.diegomfv.splendidrecipesmvvm.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diegomfv.splendidrecipesmvvm.R
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by currentScope.viewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }




}