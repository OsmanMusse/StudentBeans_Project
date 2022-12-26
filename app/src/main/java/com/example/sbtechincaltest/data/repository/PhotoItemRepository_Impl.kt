package com.example.sbtechincaltest.data.repository

import com.example.sbtechincaltest.data.mappers.toPhotoList
import com.example.sbtechincaltest.data.remote.PhotoApi
import com.example.sbtechincaltest.data.remote.PhotoItemDto
import com.example.sbtechincaltest.domain.model.PhotoItem
import com.example.sbtechincaltest.domain.repository.PhotoItemRepository
import com.example.sbtechincaltest.domain.util.Resource
import com.example.sbtechincaltest.presentation.photo_listings.PhotoItemState
import retrofit2.HttpException
import retrofit2.http.HTTP
import java.io.IOException
import javax.inject.Inject

class PhotoItemRepository_Impl @Inject constructor(
    private val api: PhotoApi
): PhotoItemRepository {
    override suspend fun getPhotoList(): Resource<List<PhotoItem>> {
        val remoteListing = try {
            val response = api.getListData()
            return Resource.Success(response.map { it.toPhotoList() })
        } catch (e: IOException){
            return Resource.Error(e.message ?: "IO ERROR")
        } catch (e:HttpException){
            return Resource.Error(e.message ?: "HTTP ERROR")
        }
    }

}