package com.harbourspace.myapplication.ui.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Links(
    val download: String,
    val download_location: String,
    val html: String,
    val self: String,
    val likes: String,
    val photos: String,
    val portfolio: String,
) : Parcelable