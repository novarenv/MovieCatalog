package com.example.moviecatalog.di.component

import com.example.moviecatalog.BaseApp
import com.example.moviecatalog.di.module.ApplicationModule
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)

}