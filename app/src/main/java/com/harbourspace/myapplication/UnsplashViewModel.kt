package com.harbourspace.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harbourspace.myapplication.ui.data.UnsplashItem
import com.harbourspace.myapplication.ui.api.UnsplashApiProvider
import com.harbourspace.myapplication.ui.data.UnsplashCollection
import com.harbourspace.myapplication.ui.data.UnsplashPhotoInfo
import com.harbourspace.myapplication.ui.data.cb.UnsplashResult

private const val TAG = "UnsplashViewModel"
class UnsplashViewModel : ViewModel(), UnsplashResult {

    private val _items = MutableLiveData<List<UnsplashItem>>()
    val items: LiveData<List<UnsplashItem>> = _items

    private val _collections = MutableLiveData<List<UnsplashCollection>>()
    val collections: LiveData<List<UnsplashCollection>> = _collections

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _photoDetails = MutableLiveData<UnsplashPhotoInfo>()
    val photoDetails: LiveData<UnsplashPhotoInfo> = _photoDetails

    fun searchImages(keyword: String) {
        provider.searchImages(keyword, this)
    }

    private val provider by lazy {
        UnsplashApiProvider()
    }

    fun fetchImages() {
        _loading.value = true

        provider.fetchImages(this)
    }

    fun fetchCollections() {
        provider.fetchCollections(this)
    }

    fun fetchPhotoDetails(id: String) {
        provider.fetchPhotoDetail(id, this)
    }

    override fun onDataFetchedSuccess(images: List<UnsplashItem>) {
        Log.d(TAG, "onDataFetchedSuccess | Received ${images.size} images")
        _items.value = images
        _loading.value = false
    }

    override fun onCollectionsFetchedSuccess(collections: List<UnsplashCollection>) {
        Log.d(TAG, "onCollectionsFetchedSuccess | Received ${collections.size} collections")
        _collections.value = collections
    }

    override fun onDataFetchedFailed() {
        Log.e(TAG, "onDataFetchedFailed | Unable to retrieve images")
        _loading.value = false
    }

    override fun onDataDetailsFetchedSuccess(photoDetails: UnsplashPhotoInfo) {
        Log.e(TAG, "onDataFetchedFailed | Unable to retrieve images")
        _photoDetails.value = photoDetails
    }
}