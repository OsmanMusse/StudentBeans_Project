package com.example.sbtechincaltest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sbtechincaltest.R
import com.example.sbtechincaltest.presentation.util.Screen
import com.example.sbtechincaltest.presentation.login_screen.LoginScreen
import com.example.sbtechincaltest.presentation.login_screen.LoginViewModel
import com.example.sbtechincaltest.presentation.photo_listings.PhotoListScreen
import com.example.sbtechincaltest.presentation.photo_listings.PhotoListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNav()
        setupUI()
    }

    private fun setupNav(){
        supportActionBar?.hide()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }

    @OptIn(ExperimentalComposeUiApi::class)
    private fun setupUI() {
        setContent {

                Surface(modifier = Modifier.fillMaxSize().background(Color.White)) {


                    val context = LocalContext.current
                    val loginViewModel = viewModels<LoginViewModel>().value
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.LoginScreen.route){
                        composable(Screen.LoginScreen.route){
                            LoginScreen(context = context, navController = navController, viewModel = loginViewModel)
                        }

                        composable(Screen.PhotoScreen.route){
                            PhotoListScreen(navigationController = navController)
                        }
                    }
                }
        }
    }



}
