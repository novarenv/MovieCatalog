package com.example.moviecatalog.ui.main

class MainPresenter: MainContract.Presenter {
    override fun attach(view: MainContract.View) {
        view.showDashboardFragment()
    }
}