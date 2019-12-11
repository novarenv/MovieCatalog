package com.example.moviecatalog.ui.main

import com.example.moviecatalog.ui.base.BaseContract

interface MainContract {
    interface View: BaseContract.View {
        fun showDashboardFragment()
    }

    interface Presenter: BaseContract.Presenter<View> {

    }
}