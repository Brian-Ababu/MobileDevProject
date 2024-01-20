package com.ababu.mobiledevproject.common

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ababu.mobiledevproject.presentation.MainViewModel
import com.ababu.mobiledevproject.presentation.common.NotificationMessage
import com.ababu.mobiledevproject.presentation.screens.auth.LoginScreen
import com.ababu.mobiledevproject.presentation.screens.auth.SignupScreen
import com.ababu.mobiledevproject.presentation.screens.main.HomeScreen
import com.ababu.mobiledevproject.presentation.screens.main.ProfileScreen

//import com.ababu.mobiledevproject.presentation.screens.main.MyProfileScreen
//import com.ababu.mobiledevproject.presentation.screens.main.MyServicesScreen
//import com.ababu.mobiledevproject.presentation.screens.main.SearchScreen
//import com.ababu.mobiledevproject.presentation.screens.main.ServiceScreen

@Composable
fun MobileApp() {
    val vm: MainViewModel = hiltViewModel()
    val navController = rememberNavController()
    NotificationMessage(vm = vm)
    NavHost(navController = navController, startDestination = Routes.Login.route) {
       composable(Routes.Home.route)  {
           HomeScreen(navController = navController)
       }
        composable(Routes.Profile.route) {
            ProfileScreen(navController = navController, vm = vm)
        }
        composable(Routes.Signup.route) {
            SignupScreen(navController = navController, vm = vm)
        }
        composable(Routes.Login.route) {
            LoginScreen(navController = navController, vm = vm)
        }
//        composable(Routes.Services.route) {
//            ServiceScreen(navController = navController, vm = vm)
//        }
//        composable(Routes.Search.route) {
//            SearchScreen(navController = navController, vm = vm)
//        }
//        composable(Routes.MyServices.route) {
//            MyServicesScreen(navController = navController, vm = vm)
//        }

    }
}