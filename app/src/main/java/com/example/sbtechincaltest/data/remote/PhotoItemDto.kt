package com.example.sbtechincaltest.data.remote

data class PhotoItemDto(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)