package com.example.moviecatalog.di.component

import com.example.moviecatalog.di.module.FragmentModule
import com.example.moviecatalog.ui.dashboard.DashboardFragment
import com.example.moviecatalog.ui.detailMovie.DetailMovieFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun inject(dashboardFragment: DashboardFragment)
    fun inject(detailMovieFragment: DetailMovieFragment)
}