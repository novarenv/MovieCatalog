package com.example.moviecatalog.di.component

import com.example.moviecatalog.di.module.ActivityModule
import com.example.moviecatalog.ui.main.MainActivity
import dagger.Component


@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}