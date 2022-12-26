package com.example.sbtechincaltest.data.mappers

import com.example.sbtechincaltest.data.remote.PhotoItemDto
import com.example.sbtechincaltest.domain.model.PhotoItem
import com.example.sbtechincaltest.presentation.photo_listings.PhotoItemState

fun PhotoItemDto.toPhotoList(): PhotoItem{
    return PhotoItem(
        title = title,
        thumbnailURL = thumbnailUrl
    )
}