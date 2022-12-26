package com.example.sbtechincaltest.presentation.photo_listings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sbtechincaltest.R
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sbtechincaltest.presentation.photo_listings.components.CenterAlignedTopBar
import com.example.sbtechincaltest.presentation.photo_listings.components.PhotoListItem
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun PhotoListScreen(
   viewModel: PhotoListViewModel = hiltViewModel(),
   navigationController: NavController
){

   val state = viewModel.state

   Scaffold(
      topBar = {
         CenterAlignedTopBar(title = "Photos",
            onclick = {
               navigationController.popBackStack()
            } )
      }
   ) {
      Column(modifier = Modifier
         .fillMaxSize()
         .padding(horizontal = 13.dp, vertical = it.calculateBottomPadding())) {
         LazyColumn(modifier = Modifier.fillMaxSize().padding(top = 15.dp), contentPadding = it, verticalArrangement = Arrangement.spacedBy(8.dp)){
            items(items = state.photoList){ photoItem ->
               PhotoListItem(photoItem)
            }
         }
      }
   }
}