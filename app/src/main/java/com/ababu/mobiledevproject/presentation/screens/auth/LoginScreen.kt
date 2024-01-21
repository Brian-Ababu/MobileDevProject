package com.ababu.mobiledevproject.presentation.screens.auth

//import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
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
import com.ababu.mobiledevproject.presentation.components.BottomComponent
import com.ababu.mobiledevproject.presentation.components.HeadingTextComponent
import com.ababu.mobiledevproject.presentation.components.MyTextFieldComponent
import com.ababu.mobiledevproject.presentation.components.NormalTextComponent
import com.ababu.mobiledevproject.presentation.components.PasswordTextFieldComponent
import com.ababu.mobiledevproject.presentation.components.myImage


@Composable
fun LoginScreen(navController : NavController, vm: MainViewModel) {
    CheckSignedIn(vm = vm, navController=navController)
    val focus = LocalFocusManager.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            val emailState = remember { mutableStateOf(TextFieldValue()) }
            val passwordState = remember { mutableStateOf(TextFieldValue()) }


            myImage(image = R.drawable.tokyo)
            HeadingTextComponent(value = "Hi, Welcome Back!" )
            NormalTextComponent(value = "Hello again you've been missed!")
            MyTextFieldComponent(
                labelValue ="myname@uxclass.live",
                icon=Icons.Outlined.Email,
                label="Email",
                value = emailState.value
            )
            PasswordTextFieldComponent(labelValue ="Please Enter Your Password", value = passwordState.value, label = "Password")

            Button( onClick = {
                focus.clearFocus(force = true)
                vm.onLogin(
                     emailState.value.text, passwordState.value.text
                )
            }, modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Log in")
            }
            BottomComponent(
                textQuery = "Don't have an account? ",
                textClickable = "Register",
                action = "Register",
                navController.navigate(Routes.Signup.route)
            )
            val isLoading = vm.inProgress.value
            if (isLoading) {
                ProgressSpinner()
            }

        }
    }
}