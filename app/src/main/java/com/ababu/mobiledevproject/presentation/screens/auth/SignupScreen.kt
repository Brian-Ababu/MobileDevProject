package com.ababu.mobiledevproject.presentation.screens.auth

import android.util.Log
import android.util.Log.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ababu.mobiledevproject.R
import com.ababu.mobiledevproject.common.Routes
import com.ababu.mobiledevproject.presentation.MainViewModel
import com.ababu.mobiledevproject.presentation.common.CheckSignedIn
import com.ababu.mobiledevproject.presentation.common.ProgressSpinner
import com.ababu.mobiledevproject.presentation.components.CheckboxComponent
import com.ababu.mobiledevproject.presentation.components.HeadingTextComponent
import com.ababu.mobiledevproject.presentation.components.MyTextFieldComponent
import com.ababu.mobiledevproject.presentation.components.NormalTextComponent
import com.ababu.mobiledevproject.presentation.components.PasswordTextFieldComponent
import com.ababu.mobiledevproject.presentation.components.myImage

@Composable
fun SignupScreen(navController: NavController, vm: MainViewModel) {
    CheckSignedIn(vm = vm, navController = navController)
//    var expanded by remember { mutableStateOf(false) }
//    var selectedRole by remember { mutableStateOf<Roles?>(null) }
    val focus = LocalFocusManager.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .wrapContentHeight()
            .verticalScroll(
                rememberScrollState()
            ),
            horizontalAlignment = Alignment.CenterHorizontally){

            val usernameState = remember { mutableStateOf(TextFieldValue()) }
            val firstNameState = remember { mutableStateOf(TextFieldValue()) }
            val lastNameState = remember { mutableStateOf(TextFieldValue()) }
            val emailState = remember { mutableStateOf(TextFieldValue()) }
            val phoneNumberState = remember { mutableStateOf(TextFieldValue()) }
            val passwordState = remember { mutableStateOf(TextFieldValue()) }

            myImage(image = R.drawable.headingimage)
            HeadingTextComponent(value = "Create an account")
            NormalTextComponent(value = "Connect with your friends today!")
            MyTextFieldComponent(
                value= usernameState.value,
                label="User Name",
                icon = Icons.Default.Person,
                onValueChange = {usernameState.value = it})
            MyTextFieldComponent(
                value= firstNameState.value,
                label="First Name",
                icon = Icons.Default.Person,
                onValueChange = {firstNameState.value = it})

            MyTextFieldComponent(
                icon = Icons.Default.Person,
                label="Last Name",
                value = lastNameState.value,
                onValueChange = {lastNameState.value = it}
            )

            MyTextFieldComponent(
                icon = Icons.Default.Email,
                label = "Email",
                value = emailState.value,
                onValueChange = {emailState.value = it})

            MyTextFieldComponent(
                icon = Icons.Default.Call,
                label="Phone Number",
                value = phoneNumberState.value,
                onValueChange = {phoneNumberState.value = it}
            )
            PasswordTextFieldComponent(
                labelValue = "password",
                label ="Password",
                value=passwordState.value,
                onValueChange = {passwordState.value = it})

            Button(
                onClick = {
                    focus.clearFocus(force = true)
                    vm.onSignup(
                       usernameState.value.text, firstNameState.value.text, lastNameState.value.text, emailState.value.text, phoneNumberState.value.text, passwordState.value.text
                    )
                    Log.d("Email:", emailState.value.text,)
//                    Log.d( "SignupScreen: check"  $emailState, $passwordState)
                }, modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "SIGN UP")
            }

            CheckboxComponent()

            Text(text = "Already a user? Go to login ->",
                color = Color.Blue,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        navController.navigate(Routes.Login.route)
                    })

            val isLoading = vm.inProgress.value
            if (isLoading) {
                ProgressSpinner()
            }

        }
    }
}