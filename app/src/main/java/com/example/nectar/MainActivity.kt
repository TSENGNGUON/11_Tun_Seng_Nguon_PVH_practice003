package com.example.nectar

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.nectar.LoginActivity
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.onboarding.OnboardingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            NectarTheme {
                OnboardingScreen(
                    onGetStarted = {
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    }
                )
            }

        }
    }
}

