package com.harbourspace.myapplication.ui.api


import com.harbourspace.myapplication.ui.data.UnsplashItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

private const val AUTHORIZATION_CLIENT_ID = "Client-ID"
private const val ACCESS_KEY = "uMpOfSWPF1X4EACEg9lMoBlhItiBISGvUqU2wELYvvY"

interface UnsplashApi {

    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("photos")
    fun fetchPhotos() : Call<List<UnsplashItem>>
}