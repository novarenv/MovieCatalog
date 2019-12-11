package com.example.moviecatalog.ui.base

interface BaseContract {
    interface View{

    }

    interface Presenter<in T> {
        fun attach(view: T)
    }
}