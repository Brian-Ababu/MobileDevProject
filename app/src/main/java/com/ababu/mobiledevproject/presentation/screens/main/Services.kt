package com.ababu.mobiledevproject.presentation.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ababu.mobiledevproject.presentation.MainViewModel

@Composable
fun ServiceScreen(navController: NavController, vm: MainViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Service Screen")

        //Add ability to book an appointment online
        //Booking to get your hair done
        //Ability to choose your date, time and hairdresser
        //Store the hair dresser list
        //inform the customer if booking is successful
        //Set maximum limit for bookings per hairdresser (5 per day)

        BottomNavigationMenu(
            selectedItem = BottomNavigationItem.SERVICES,
            navController = navController
        )

    }
}