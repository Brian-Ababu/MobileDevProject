package com.ababu.mobiledevproject.presentation.screens.main

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ababu.mobiledevproject.common.Routes
import com.ababu.mobiledevproject.presentation.MainViewModel
import com.ababu.mobiledevproject.presentation.common.CommonImage
import com.ababu.mobiledevproject.presentation.common.ProgressSpinner
import com.ababu.mobiledevproject.presentation.common.navigateTo

@Composable
fun ProfileScreen(navController: NavController, vm:MainViewModel){
    //Check if data is being loaded
    val isLoading = vm.inProgress.value
    if (isLoading) {
        ProgressSpinner()
    } else {
        //Retrieve user data
        val userData = vm.userData.value
        Log.d("userData", "userData: $userData")

        // Initialize mutable state variables for the firstname, lastname, username, and bio
        var firstname by rememberSaveable { mutableStateOf(userData?.firstname ?: "") }
        var lastname by rememberSaveable { mutableStateOf(userData?.lastname ?: "") }
        var username by rememberSaveable { mutableStateOf(userData?.username ?: "") }
        var bio by rememberSaveable { mutableStateOf(userData?.bio ?: "") }
        Log.d("prof", "firstname: $firstname, lastname: $lastname, username: $username, bio: $bio")

        //Render the profile content
        ProfileContent(
            vm = vm,
            firstname = firstname,
            lastname = lastname,
            username = username,
            bio = bio,
            onFirstNameChange = { firstname = it},
            onLastNameChange = { lastname = it },
            onUsernameChange = { username = it },
            onBioChange = { bio = it },
            onSave = { vm.updateProfileData(firstname, lastname, username, bio) },
            onBack = { navigateTo(navController = navController, Routes.Services) },
            onLogout = {
                vm.onLogout()
                navigateTo(navController, Routes.Login)
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileContent(
    vm: MainViewModel,
    firstname: String,
    lastname: String,
    username: String,
    bio: String,
    onFirstNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onUsernameChange: (String) -> Unit,
    onBioChange: (String) -> Unit,
    onSave: () -> Unit,
    onBack: () -> Unit,
    onLogout: () -> Unit
) {
    val scrollState = rememberScrollState()
    val imageUrl = vm.userData?.value?.imageUrl

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Back", modifier = Modifier.clickable { onBack.invoke() })
            Text(text = "Save", modifier = Modifier.clickable { onSave.invoke() })
        }


        ProfileImage(imageUrl = imageUrl, vm = vm)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "First Name", modifier = Modifier.width(100.dp))
            TextField(
                value = firstname,
                onValueChange = onFirstNameChange,
                colors = TextFieldDefaults.textFieldColors(

                    textColor = Color.White
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Last Name", modifier = Modifier.width(100.dp))
            TextField(
                value = lastname,
                onValueChange = onLastNameChange,
                colors = TextFieldDefaults.textFieldColors(

                    textColor = Color.White
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Username", modifier = Modifier.width(100.dp))
            TextField(
                value = username,
                onValueChange = onUsernameChange,
                colors = TextFieldDefaults.textFieldColors(

                    textColor = Color.White
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.Top
        ) {
            Text(text = "Bio", modifier = Modifier.width(100.dp))
            TextField(
                value = bio,
                onValueChange = onBioChange,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.White
                ),
                singleLine = false,
                modifier = Modifier.height(150.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Logout", modifier = Modifier.clickable { onLogout.invoke() })
        }
    }
}

@Composable
fun ProfileImage(imageUrl: String?, vm: MainViewModel) {

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {uri: Uri? ->
        uri?.let { vm.uploadProfileImage(uri) }
    }

    Box(modifier = Modifier.height(IntrinsicSize.Min)) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable { launcher.launch("image/*") },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = CircleShape,
                modifier = Modifier
                    .padding(8.dp)
                    .size(100.dp)
            ) {
                CommonImage(data = imageUrl)
            }
            Text(text = "Change profile picture")
        }

        val isLoading = vm.inProgress.value
        if (isLoading)
            ProgressSpinner()
    }
}

