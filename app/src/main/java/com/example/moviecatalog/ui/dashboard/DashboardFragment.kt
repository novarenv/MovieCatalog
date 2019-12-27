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
import com.example.moviecatalog.ui.detailMovie.DetailMovieFragment
import javax.inject.Inject

class DashboardFragment : Fragment(), DashboardContract.View, View.OnClickListener {
    @Inject
    lateinit var presenter: DashboardContract.Presenter

    private lateinit var rootView: View
    private lateinit var myContext: FragmentActivity
    private lateinit var adapter: DashboardAdapter
    private lateinit var moviePhoto: TypedArray
    private lateinit var movieTitle: Array<String>
    private lateinit var movieDesc: Array<String>
    private lateinit var movieDate: Array<String>
    private lateinit var movieTime: Array<String>
    private lateinit var movieSeat: Array<String>
    private var movieCatalogs = ArrayList<MovieCatalog>()
    private val detailMovieFragment: Fragment = DetailMovieFragment().newInstance()
    private val bundle = Bundle()

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

        presenter.attach(this)
        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            bundle.putParcelable("DetailMovie", adapter.movieCatalogs.get(position))
            detailMovieFragment.arguments = bundle

            Toast.makeText(myContext, movieCatalogs[position].title, Toast.LENGTH_SHORT).show()
            presenter.onDetailMovieClick()
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
        moviePhoto = resources.obtainTypedArray(R.array.movie_photo)
        movieTitle = resources.getStringArray(R.array.movie_title)
        movieDesc = resources.getStringArray(R.array.movie_desc)
        movieDate = resources.getStringArray(R.array.movie_date)
        movieTime = resources.getStringArray(R.array.movie_time)
        movieSeat = resources.getStringArray(R.array.movie_seat)
    }

    private fun addItem() {
        for (position in movieTitle.indices) {
            val movieCatalog = MovieCatalog(
                moviePhoto.getResourceId(position, -1),
                movieTitle[position],
                movieDesc[position],
                movieDate[position],
                movieTime[position],
                movieSeat[position]
            )
            if (!movieCatalogs.contains(movieCatalog))
                movieCatalogs.add(movieCatalog)
        }
        adapter.movieCatalogs = movieCatalogs
    }

    override fun showDetailMovieFragment() {
        fragmentManager!!.beginTransaction()
            .addToBackStack(DetailMovieFragment.TAG)
            .replace(R.id.fl_main, detailMovieFragment, DetailMovieFragment.TAG)
            .commit()
//        changeFragment.showDetailMovieFragment(myContext)
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