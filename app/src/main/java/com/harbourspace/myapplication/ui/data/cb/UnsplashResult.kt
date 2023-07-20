package com.harbourspace.myapplication.ui.data.cb

import com.harbourspace.myapplication.ui.data.UnsplashItem


interface UnsplashResult {

    fun onDataFetchedSuccess(images: List<UnsplashItem>)

    fun onDataFetchedFailed()
}