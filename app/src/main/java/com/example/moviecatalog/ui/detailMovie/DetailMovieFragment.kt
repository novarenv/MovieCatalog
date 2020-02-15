package com.example.moviecatalog.ui.detailMovie

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.moviecatalog.R
import com.example.moviecatalog.di.component.DaggerFragmentComponent
import com.example.moviecatalog.di.module.FragmentModule
import com.example.moviecatalog.model.MovieCatalog
import javax.inject.Inject

class DetailMovieFragment: Fragment(), DetailMovieContract.View {
    @Inject
    lateinit var presenter: DetailMovieContract.Presenter

    private lateinit var rootView: View
    private lateinit var myContext: FragmentActivity
    private lateinit var ivMovie: ImageView
    private lateinit var tvMTitle: TextView
    private lateinit var tvMDate: TextView
    private lateinit var tvMTime: TextView
    private lateinit var tvMSeat: TextView
    private var movieCatalog: MovieCatalog?= null

    fun newInstance(): DetailMovieFragment {
        Log.e("newInstance", "Detail Movie Fragment Instance")
        return DetailMovieFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDetailMovie()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fm_detail_movie, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this.arguments

        ivMovie = view.findViewById(R.id.iv_movie)
        tvMTitle = view.findViewById(R.id.tv_m_title)
        tvMDate = view.findViewById(R.id.tv_m_date)
        tvMTime = view.findViewById(R.id.tv_m_time)
        tvMSeat = view.findViewById(R.id.tv_m_seat)

        if (bundle != null) Log.e("Bundle", "Bundle is not null")

        movieCatalog = bundle?.getParcelable("DetailMovie")

        ivMovie.setImageResource(movieCatalog?.photo as Int)
        tvMTitle.text = movieCatalog?.title
        tvMDate.text = movieCatalog?.date
        tvMTime.text = movieCatalog?.time
        tvMSeat.text = movieCatalog?.seat
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
        val TAG: String = "Detail Movie Fragment"
    }
}