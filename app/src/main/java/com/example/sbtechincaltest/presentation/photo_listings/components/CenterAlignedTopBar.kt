package com.example.sbtechincaltest.presentation.photo_listings.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.sbtechincaltest.R

@Composable
fun CenterAlignedTopBar(title: String, onclick: () -> Unit){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black,
            )
        },

        navigationIcon = {
            IconButton(
                onClick = {
                    onclick()
                }
            ) {
                Icon(painter = painterResource(R.drawable.back_arrow), contentDescription = "")
            }
        }
    )
}