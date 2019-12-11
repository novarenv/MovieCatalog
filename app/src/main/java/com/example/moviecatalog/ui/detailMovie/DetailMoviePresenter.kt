package com.example.moviecatalog.ui.detailMovie

import android.util.Log

class DetailMoviePresenter: DetailMovieContract.Presenter  {
    private lateinit var view: DetailMovieContract.View

    override fun attach(view: DetailMovieContract.View) {
        Log.e("error", "Attach view")
        this.view = view
    }
}