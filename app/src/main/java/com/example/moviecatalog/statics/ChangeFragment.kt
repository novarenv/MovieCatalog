package com.example.moviecatalog.statics

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.example.moviecatalog.R
import com.example.moviecatalog.ui.dashboard.DashboardFragment
import com.example.moviecatalog.ui.detailMovie.DetailMovieFragment
import com.example.moviecatalog.ui.main.MainActivity

object ChangeFragment {
    fun start(fragmentManager: FragmentManager, frameResourceID: Int, fragment: Fragment?, TAG: String) {
        fragmentManager.beginTransaction()
            .addToBackStack(TAG)
            .replace(frameResourceID, fragment!!, TAG)
            .commit()
    }

    fun showDetailMovieFragment(myContext: FragmentActivity) {
        this.start(myContext.supportFragmentManager, R.id.fl_main, DetailMovieFragment().newInstance(),
            DetailMovieFragment.TAG)
    }

    fun showDashboardFragment(myContext: FragmentActivity) {
        this.start(myContext.supportFragmentManager, R.id.fl_main, DashboardFragment().newInstance(),
            DashboardFragment.TAG)
    }
}