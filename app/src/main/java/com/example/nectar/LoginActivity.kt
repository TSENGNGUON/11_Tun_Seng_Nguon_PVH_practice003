package com.example.nectar

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.loginScreen.LoginScreen

class LoginActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            NectarTheme {
                LoginScreen(
                    onSignUpClick = {
                        val intent = Intent(this, SignUpActivity::class.java)
                        startActivity(intent)
                    },
                    onLoginClick = {
                        val intent = Intent(this, HomePageActivity::class.java)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}