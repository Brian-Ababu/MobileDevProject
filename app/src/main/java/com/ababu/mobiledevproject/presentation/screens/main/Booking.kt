package com.ababu.mobiledevproject.presentation.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ababu.mobiledevproject.common.Routes
import com.ababu.mobiledevproject.presentation.MainViewModel
import com.ababu.mobiledevproject.presentation.components.HeadingTextComponent

@Composable
fun BookingScreen(navController: NavController, vm: MainViewModel) {


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        //Add ability to book an appointment online
        //Ability to choose your date, time and hairdresser
        //Store the hair dresser list
        //inform the customer if booking is successful via email
        //Set maximum limit for bookings per hairdresser (5 per day)

        BottomNavigationMenu(
            selectedItem = BottomNavigationItem.SERVICES,
            navController = navController
        )

        HeadingTextComponent(value = "Booking Screen")

        Text(modifier = Modifier.clickable { navController.navigate(Routes.Style.route) }, text = "Share your hair design choices")
    }
}