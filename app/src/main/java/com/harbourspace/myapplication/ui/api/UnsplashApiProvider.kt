package com.harbourspace.myapplication.ui.api

import com.harbourspace.myapplication.ui.data.UnsplashCollection
import com.harbourspace.myapplication.ui.data.UnsplashItem
import com.harbourspace.myapplication.ui.data.UnsplashPhotoInfo
import com.harbourspace.myapplication.ui.data.UnsplashSearch
import com.harbourspace.myapplication.ui.data.cb.UnsplashResult
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

private const val BASE_URL = "https://api.unsplash.com/"

class UnsplashApiProvider {

    private val retrofit by lazy {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create<UnsplashApi>()
    }

    fun fetchImages(cb: UnsplashResult) {
        retrofit.fetchPhotos().enqueue(object : Callback<List<UnsplashItem>> {
            override fun onResponse(
                call: Call<List<UnsplashItem>>,
                response: Response<List<UnsplashItem>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    cb.onDataFetchedSuccess(response.body()!!)
                } else {
                    cb.onDataFetchedFailed()
                }

            }

            override fun onFailure(call: Call<List<UnsplashItem>>, t: Throwable) {
                cb.onDataFetchedFailed()
            }
        })
    }

    fun searchImages(keyword: String, cb: UnsplashResult) {
        retrofit.searchPhotos(keyword).enqueue(object : Callback<UnsplashSearch> {
            override fun onResponse(call: Call<UnsplashSearch>, response: Response<UnsplashSearch>) {
                if (response.isSuccessful && response.body() != null) {
                    cb.onDataFetchedSuccess(response.body()!!.results)
                } else {
                    cb.onDataFetchedFailed()
                }
            }

            override fun onFailure(call: Call<UnsplashSearch>, t: Throwable) {
                cb.onDataFetchedFailed()
            }
        })
    }

    fun fetchCollections(cb: UnsplashResult) {
        retrofit.fetchCollections().enqueue(object : Callback<List<UnsplashCollection>> {
            override fun onResponse(call: Call<List<UnsplashCollection>>, response: Response<List<UnsplashCollection>>) {
                if (response.isSuccessful && response.body() != null) {
                    cb.onCollectionsFetchedSuccess(response.body()!!)
                } else {
                    cb.onDataFetchedFailed()
                }
            }

            override fun onFailure(call: Call<List<UnsplashCollection>>, t: Throwable) {
                cb.onDataFetchedFailed()
            }
        })
    }

    fun fetchPhotoDetail(id: String, cb: UnsplashResult) {
        retrofit.fetchPhotoDetail(id).enqueue(object : Callback<UnsplashPhotoInfo> {
            override fun onResponse(call: Call<UnsplashPhotoInfo>, response: Response<UnsplashPhotoInfo>) {
                if (response.isSuccessful && response.body() != null) {
                    cb.onDataDetailsFetchedSuccess(response.body()!!)
                } else {
                    cb.onDataFetchedFailed()
                }
            }

            override fun onFailure(call: Call<UnsplashPhotoInfo>, t: Throwable) {
                cb.onDataFetchedFailed()
            }
        })
    }
}
