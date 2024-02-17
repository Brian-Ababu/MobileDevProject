package com.ababu.mobiledevproject.presentation.screens.main

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ababu.mobiledevproject.R
import com.ababu.mobiledevproject.data.CardData
import com.ababu.mobiledevproject.presentation.MainViewModel
import com.ababu.mobiledevproject.presentation.components.ImageCardList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Screen lists the services offered
fun ServiceScreen(navController: NavController, vm: MainViewModel) {

//Figure out how to render multiple cards

    var cardDataList = listOf(
        CardData(R.drawable.barber_shop, "Barber Shop Appointment"),
     //   CardData(R.drawable.hair_salon, "Hair Stylist /Appointment")
//        CardData(R.drawable.massage_appointment, "Massage Appointment")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
            .padding(16.dp)
    ) {

        TopAppBar(
            title = { Text(text = "Our Services") },
        )

        BottomNavigationMenu(
            selectedItem = BottomNavigationItem.SERVICES,
            navController = navController
        )

        ImageCardList(cardDataList = cardDataList, navController = navController)

        Log.d("image cards", "$cardDataList")

    }
}