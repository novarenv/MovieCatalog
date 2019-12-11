package com.example.moviecatalog.ui.dashboard

import android.app.Activity
import android.content.res.TypedArray
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.moviecatalog.R
import com.example.moviecatalog.di.component.DaggerFragmentComponent
import com.example.moviecatalog.di.module.FragmentModule
import com.example.moviecatalog.model.MovieCatalog
import javax.inject.Inject

class DashboardFragment : Fragment(), DashboardContract.View, View.OnClickListener {
    @Inject
    lateinit var presenter: DashboardContract.Presenter

    private lateinit var rootView: View
    private lateinit var myContext: FragmentActivity
    private lateinit var adapter: DashboardAdapter
    private lateinit var dataPhoto: TypedArray
    private lateinit var dataTitle: Array<String>
    private lateinit var dataDesc: Array<String>
    private var movieCatalogs = ArrayList<MovieCatalog>()

    fun newInstance(): DashboardFragment {
        Log.e("error", "Dashboard Fragment Instance")
        return DashboardFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDashboard()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fm_dashboard, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView: ListView = view.findViewById(R.id.lv_movies)

        adapter = DashboardAdapter(myContext)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(myContext, movieCatalogs[position].title, Toast.LENGTH_SHORT).show()
        }
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

    private fun prepare() {
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        dataTitle = resources.getStringArray(R.array.data_title)
        dataDesc = resources.getStringArray(R.array.data_desc)
    }

    private fun addItem() {
        for (position in dataTitle.indices) {
            val movieCatalog = MovieCatalog(
                dataPhoto.getResourceId(position, -1),
                dataTitle[position],
                dataDesc[position]
            )
            movieCatalogs.add(movieCatalog)
        }
        adapter.movieCatalogs = movieCatalogs
    }

    fun injectDashboard() {
        val listComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        listComponent.inject(this)
    }

    companion object{
        val TAG: String = "Dashboard Fragment"
    }
}