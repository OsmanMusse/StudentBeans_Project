package com.example.sbtechincaltest.presentation.photo_listings

import com.example.sbtechincaltest.domain.model.PhotoItem

data class PhotoItemState(
    val photoList: List<PhotoItem> = listOf(),
    val isLoading: Boolean = false
) {
}