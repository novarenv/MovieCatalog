package com.example.moviecatalog.di.module

import com.example.moviecatalog.ui.dashboard.DashboardContract
import com.example.moviecatalog.ui.dashboard.DashboardPresenter
import com.example.moviecatalog.ui.detailMovie.DetailMovieContract
import com.example.moviecatalog.ui.detailMovie.DetailMoviePresenter
import dagger.Module
import dagger.Provides


@Module
class FragmentModule {
    @Provides
    fun provideDashboardPresenter(): DashboardContract.Presenter{
        return DashboardPresenter()
    }

    @Provides
    fun provideDetailMoviePresenter(): DetailMovieContract.Presenter{
        return DetailMoviePresenter()
    }
}