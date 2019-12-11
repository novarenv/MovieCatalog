package com.example.moviecatalog.ui.detailMovie

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.moviecatalog.R
import com.example.moviecatalog.di.component.DaggerFragmentComponent
import com.example.moviecatalog.di.module.FragmentModule
import com.example.moviecatalog.ui.dashboard.DashboardFragment
import javax.inject.Inject

class DetailMovieFragment: Fragment(), DetailMovieContract.View, View.OnClickListener {
    @Inject
    lateinit var presenter: DetailMovieContract.Presenter

    private lateinit var rootView: View
    private lateinit var myContext: FragmentActivity

    fun newInstance(): DashboardFragment {
        Log.e("error", "Dashboard Fragment Instance")
        return DashboardFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDetailMovie()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fm_dashboard, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onClick(v: View?) {
        Log.e("error", "Click")

        when(v?.id) {

        }
    }

    override fun onAttach(activity: Activity) {
        myContext = activity as FragmentActivity
        super.onAttach(activity)
    }

    fun injectDetailMovie() {
        val listComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        listComponent.inject(this)
    }

    companion object{
        val TAG: String = "Dashboard Fragment"
    }
}