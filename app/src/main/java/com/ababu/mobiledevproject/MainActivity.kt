package com.ababu.mobiledevproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ababu.mobiledevproject.common.MobileApp
import com.ababu.mobiledevproject.presentation.ui.theme.MobileDevProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MobileDevProjectTheme {
                MobileApp()
            }
        }
    }
}