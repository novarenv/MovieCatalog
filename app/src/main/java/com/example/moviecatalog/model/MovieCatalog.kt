package com.example.moviecatalog.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieCatalog(
    val photo: Int,
    val title: String,
    val desc: String,
    val date: String,
    val time: String,
    val seat: String
): Parcelable