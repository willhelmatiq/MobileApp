package com.harbourspace.myapplication.ui.data.cb

import com.harbourspace.myapplication.ui.data.UnsplashCollection
import com.harbourspace.myapplication.ui.data.UnsplashItem
import com.harbourspace.myapplication.ui.data.UnsplashPhotoInfo


interface UnsplashResult {

    fun onDataFetchedSuccess(images: List<UnsplashItem>)

    fun onCollectionsFetchedSuccess(collections: List<UnsplashCollection>)
    fun onDataFetchedFailed()

    fun onDataDetailsFetchedSuccess(photoDetails: UnsplashPhotoInfo)
}