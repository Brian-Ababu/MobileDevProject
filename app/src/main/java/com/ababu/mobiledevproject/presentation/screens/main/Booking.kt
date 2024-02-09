package com.ababu.mobiledevproject.presentation.screens.main
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import com.ababu.mobiledevproject.common.Routes
//import com.ababu.mobiledevproject.presentation.MainViewModel
//import com.ababu.mobiledevproject.presentation.components.HeadingTextComponent
//
//@Composable
//fun BookingScreen(navController: NavController, vm: MainViewModel) {
//
//
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .padding(16.dp)) {
//
//        //Add ability to book an appointment online
//        //Ability to choose your date, time and hairdresser
//        //Store the hair dresser list
//        //inform the customer if booking is successful via email
//        //Set maximum limit for bookings per hairdresser (5 per day)
//
//        BottomNavigationMenu(
//            selectedItem = BottomNavigationItem.SERVICES,
//            navController = navController
//        )
//
//        HeadingTextComponent(value = "Booking Screen")
//
//        Text(modifier = Modifier.clickable { navController.navigate(Routes.Style.route) }, text = "Share your hair design choices")
//    }
//}


import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ababu.mobiledevproject.common.Routes
import com.ababu.mobiledevproject.presentation.MainViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(navController: NavController, vm: MainViewModel) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Booking Screen") }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text(text = "Username") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                DatePicker(
                    selectedDate = selectedDate,
                    onDateSelected = { selectedDate = it }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* Handle booking logic here */ },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = "Book Appointment")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(modifier = Modifier.clickable { navController.navigate(Routes.Style.route) }, text = "Share your hair design choices")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePicker(selectedDate: String, onDateSelected: (String) -> Unit) {
    var date by remember { mutableStateOf("") }

    TextField(
        value = if (selectedDate.isNotEmpty()) selectedDate else date,
        onValueChange = { date = it },
        label = { Text(text = "Select Date") },
        leadingIcon = { Icon(Icons.Filled.DateRange, contentDescription = "Select Date") },
        modifier = Modifier.fillMaxWidth()
    )
    if (selectedDate.isNotEmpty()) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Selected Date: $selectedDate",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

//@Preview
//@Composable
//fun BookingScreenPreview() {
//    BookingScreen()
//}