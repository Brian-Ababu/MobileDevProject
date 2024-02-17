package com.ababu.mobiledevproject.presentation.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ababu.mobiledevproject.common.Routes
import com.ababu.mobiledevproject.presentation.MainViewModel
import java.text.SimpleDateFormat
import java.util.Date


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(navController: NavController, vm: MainViewModel) {
    var username by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var description by remember { mutableStateOf(TextFieldValue()) }
    var selectedDate by remember { mutableStateOf(Date()) }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState(), enabled = true)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TopAppBar(
            title = { Text(text = "Book Appointment") },
        )

        OutlinedTextField(
            value = username.textFieldValue(),
            onValueChange = { username = it },
            label = { Text(text = "Username") },
            leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "User") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = email.textFieldValue(),
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Email Address") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = description.textFieldValue(),
            onValueChange = { description = it },
            label = { Text(text = "Service Description") },
            leadingIcon = { Icon(Icons.Filled.Add, contentDescription = "What service are you getting?") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        DatePicker(
            selectedDate = selectedDate,
            onDateSelected = { selectedDate = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                vm.onNewBooking(
                    username.textFieldValue().text,
                    email.textFieldValue().text,
                    description.textFieldValue().text,
                    date = selectedDate,
                    onBookingSuccess ={
                        navController.navigate(Routes.Services.route)
                    }
                )
            },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text(text = "Book Appointment")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier
                .padding(16.dp)
                .clickable { navController.navigate(Routes.Style.route) },
            text = "Click to share your hair design choices with us!"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePicker(selectedDate: Date, onDateSelected: (Date) -> Unit) {
    var date by remember { mutableStateOf("") }

    // Format the selected date for display in TextField
    val selectedDateString = SimpleDateFormat("yyyy-MM-dd").format(selectedDate)

    if (selectedDateString.isEmpty()) {
        date = selectedDateString
    }

    TextField(
        value = if (selectedDateString.isNotEmpty()) selectedDateString else date,
        onValueChange = { date = it },
        label = { Text(text = "Select Date") },
        leadingIcon = { Icon(Icons.Filled.DateRange, contentDescription = "Select Date") },
        modifier = Modifier.fillMaxWidth()
    )

    // Parse the date back to Date and invoke onDateSelected
    if (date.isNotEmpty()) {
        val parsedDate = SimpleDateFormat("yyyy-MM-dd").parse(date)
        onDateSelected(parsedDate)
    }
}

//function to return the text feild value
private fun TextFieldValue.textFieldValue(): TextFieldValue {
    return this
}