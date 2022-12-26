package com.example.sbtechincaltest.presentation.photo_listings.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.sbtechincaltest.domain.model.PhotoItem
import com.example.sbtechincaltest.presentation.theme.LightGray


@Composable
fun PhotoListItem(photoItem: PhotoItem) {
    Row(modifier = Modifier
        .fillMaxSize()
        .background(color = LightGray)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = photoItem.thumbnailURL),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "${photoItem.title}",
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically),
            fontSize = 16.sp
        )
    }
}