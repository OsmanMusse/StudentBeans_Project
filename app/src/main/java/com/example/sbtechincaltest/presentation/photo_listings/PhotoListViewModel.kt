package com.example.sbtechincaltest.presentation.photo_listings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sbtechincaltest.domain.repository.PhotoItemRepository
import com.example.sbtechincaltest.domain.util.Resource
import com.example.sbtechincaltest.presentation.photo_listings.components.PhotoListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val repository: PhotoItemRepository
): ViewModel() {

    var state by mutableStateOf(PhotoItemState())

    init {
        getPhotoLists()
    }


    fun getPhotoLists(){
        viewModelScope.launch {
            val result = repository.getPhotoList()
            println("FINAL RESULT == ${result}")
            when(result){
                is Resource.Success -> {
                    result.data?.let { listings ->
                        state = state.copy(photoList = listings)
                    }
                }
                is Resource.Error -> Unit
            }
        }
    }
}