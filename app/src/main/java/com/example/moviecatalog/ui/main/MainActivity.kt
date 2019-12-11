package com.example.moviecatalog.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviecatalog.R
import com.example.moviecatalog.di.component.DaggerActivityComponent
import com.example.moviecatalog.di.module.ActivityModule
import com.example.moviecatalog.statics.ChangeFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {
    @Inject lateinit var presenter: MainContract.Presenter

    private var changeFragment: ChangeFragment = ChangeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectDependency()

        presenter.attach(this)
    }

    override fun showDashboardFragment() {
        changeFragment.showDashboardFragment(this)
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }
}