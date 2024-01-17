package com.ababu.mobiledevproject.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ababu.mobiledevproject.R
import com.ababu.mobiledevproject.common.Routes
import com.ababu.mobiledevproject.presentation.common.navigateTo
import com.ababu.mobiledevproject.presentation.components.myImage


@Composable
fun HomeScreen(navController: NavController){
    val focus = LocalFocusManager.current
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .verticalScroll(
                rememberScrollState()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        myImage(image = R.drawable.headingimage)
        Button( onClick = {
            focus.clearFocus(force = true)
            navController.navigate(Routes.Signup.route)
        }, modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Sign up")
        }
        }
    }
}