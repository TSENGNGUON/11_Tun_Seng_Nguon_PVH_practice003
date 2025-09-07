package com.example.nectar

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.signupScreen.SignupScreen


class SignUpActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NectarTheme {
                SignupScreen(onLoginClick = {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                })
            }
        }
    }
}