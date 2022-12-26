package com.example.sbtechincaltest.domain.repository

import com.example.sbtechincaltest.data.remote.PhotoItemDto
import com.example.sbtechincaltest.domain.model.PhotoItem
import com.example.sbtechincaltest.domain.util.Resource
import com.example.sbtechincaltest.presentation.photo_listings.PhotoItemState

interface PhotoItemRepository {

        suspend fun getPhotoList(): Resource<List<PhotoItem>>
}