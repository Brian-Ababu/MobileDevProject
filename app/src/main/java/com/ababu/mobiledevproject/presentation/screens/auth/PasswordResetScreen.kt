package com.ababu.mobiledevproject.presentation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import com.ababu.mobiledevproject.presentation.MainViewModel
import com.ababu.mobiledevproject.presentation.common.CheckSignedIn
import com.ababu.mobiledevproject.presentation.components.HeadingTextComponent
import com.ababu.mobiledevproject.presentation.components.MyTextFieldComponent
import com.ababu.mobiledevproject.presentation.components.myImage

@Composable
fun PasswordResetScreen(navController: NavController, vm:  MainViewModel){

    CheckSignedIn(vm = vm, navController=navController)
    val emailState = remember { mutableStateOf(TextFieldValue()) }
    val focus = LocalFocusManager.current
    Surface(
        modifier = Modifier
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            myImage(image = R.drawable.headingimage)
            HeadingTextComponent(value = "Reset Password")
            MyTextFieldComponent(
                icon = Icons.Outlined.Email,
                label = "Email",
                value = emailState.value,
                onValueChange = { emailState.value = it }
            )

            Button(
                onClick = {
                    focus.clearFocus(force = true)
                    vm.onPasswordReset(
                        emailState.value.text
                    )
                }, modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Reset Password")
            }
        }
    }
}