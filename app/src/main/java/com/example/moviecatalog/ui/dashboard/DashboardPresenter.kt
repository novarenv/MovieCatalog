package com.example.moviecatalog.ui.dashboard

import android.util.Log

class DashboardPresenter: DashboardContract.Presenter {
    private lateinit var view: DashboardContract.View

    override fun attach(view: DashboardContract.View) {
        Log.e("error", "Attach view")
        this.view = view
    }
}