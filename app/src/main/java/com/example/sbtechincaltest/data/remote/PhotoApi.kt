package com.example.sbtechincaltest.data.remote

import retrofit2.http.GET


interface PhotoApi {

   @GET("/photos")
    suspend fun getListData(): List<PhotoItemDto>
}