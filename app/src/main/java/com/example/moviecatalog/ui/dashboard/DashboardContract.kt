package com.example.moviecatalog.ui.dashboard

import com.example.moviecatalog.ui.base.BaseContract

interface DashboardContract {
    interface View: BaseContract.View{
        fun showDetailMovieFragment()
    }

    interface Presenter: BaseContract.Presenter<View>{
        fun onDetailMovieClick()
    }
}