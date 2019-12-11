package com.example.moviecatalog.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.moviecatalog.R
import com.example.moviecatalog.model.MovieCatalog

class DashboardAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var movieCatalogs = arrayListOf<MovieCatalog>()

    override fun getCount(): Int = movieCatalogs.size

    override fun getItem(i: Int): Any = movieCatalogs[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as MovieCatalog
        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val tvMTitle: TextView = view.findViewById(R.id.tv_m_title)
        private val tvMDesc: TextView = view.findViewById(R.id.tv_m_desc)
        private val imgPhoto: ImageView = view.findViewById(R.id.iv_movie)

        internal fun bind(movieCatalog: MovieCatalog) {
            tvMTitle.text = movieCatalog.title
            tvMDesc.text = movieCatalog.desc
            imgPhoto.setImageResource(movieCatalog.photo)
        }
    }
}