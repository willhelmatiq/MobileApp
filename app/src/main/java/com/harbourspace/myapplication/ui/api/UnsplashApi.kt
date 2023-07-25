package com.harbourspace.myapplication.ui.api


import com.harbourspace.myapplication.ui.data.UnsplashCollection
import com.harbourspace.myapplication.ui.data.UnsplashItem
import com.harbourspace.myapplication.ui.data.UnsplashSearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val AUTHORIZATION_CLIENT_ID = "Client-ID"
private const val ACCESS_KEY = "uMpOfSWPF1X4EACEg9lMoBlhItiBISGvUqU2wELYvvY"

interface UnsplashApi {

    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("photos")
    fun fetchPhotos() : Call<List<UnsplashItem>>

    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("search/photos")
    fun searchPhotos(@Query(value = "query") keyword : String): Call<UnsplashSearch>

    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("collections")
    fun fetchCollections() : Call<List<UnsplashCollection>>
}