package com.example.nectar.ui.theme.loginScreen

import android.content.Context
import android.graphics.BitmapFactory
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.ui.theme.NectarTheme
import java.io.IOException
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onLoginClick: (context: Context) -> Unit, onSignUpClick: (context: Context) -> Unit = {}, onForgotPasswordClick: () -> Unit = {}) {
    var email by remember { mutableStateOf("sengn5112@gmail.com") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFCFCFC))
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Image(
            painter = painterResource(id = R.drawable.carrot_color),
            contentDescription = "Carrot Logo",
            modifier = Modifier.size(48.dp).align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(80.dp))

        //Login Title
        Text(
            text = "Logging",
            fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF181725)
        )
        Spacer(modifier = Modifier.height(8.dp))
        //Subtitle
        Text(
            text = "Enter your emails and password",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF7c7c7c)
        )
        Spacer(modifier = Modifier.height(40.dp))
        // Email Field
        Text(
            text = "Email",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF7c7c7c),
            modifier = Modifier.padding(bottom = 8.dp)

        )
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            placeholder = {
                Text("Enter your email",
                    color = Color(0xFF7c7c7c))

            },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF53B175),
                unfocusedBorderColor = Color(0xFFE2E2E2),
                focusedTextColor = Color(0xFF181725),
                unfocusedTextColor = Color(0xFF181725)
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        // password field
        Text(
            text = "Password",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF7c7c7c),
            modifier = Modifier.padding(bottom = 8.dp)

        )
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            placeholder = {
                Text("Enter your password",
                    color = Color(0xFF7c7c7c))

            },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF53B175),
                unfocusedBorderColor = Color(0xFFE2E2E2),
                focusedTextColor = Color(0xFF181725),
                unfocusedTextColor = Color(0xFF181725)
            ),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(
                    onClick = {
                        isPasswordVisible = !isPasswordVisible
                    }
                ) {
                    Icon(
                        painter = painterResource(
                            if (isPasswordVisible)
                                R.drawable.ic_menu_view
                            else
                                R.drawable.visibility_offf
                        ),
                        contentDescription = if (isPasswordVisible) "Hide password" else "Show password",
                        tint = Color(0xFF7c7c7c)
                    )
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        // forgot password
        Text(
            text = "Forgot Password?",
            fontSize = 14.sp,
            color = Color(0xFF181725),
            modifier = Modifier.
            align(alignment = Alignment.End)
                .clickable{
                    onForgotPasswordClick()
                }

        )

        Spacer(modifier = Modifier.height(40.dp))
        // Login Button
        Button(
            onClick = { onLoginClick(context) },
            modifier = Modifier.fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF53b175)
            ),
            shape = RoundedCornerShape(19.dp)
        ) {
            Text("Log In",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White)

        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sign up text

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Don't have an account? ",
                fontSize = 14.sp,
                color = Color(0xff181725)
            )
            Text(
                text = "Signup",
                fontSize = 14.sp,
                color = Color(0xff53b175),
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable {
                    onSignUpClick(context)
                }
            )
        }


    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    NectarTheme {
        LoginScreen(
            onLoginClick = TODO(),
            onSignUpClick = TODO(),
            onForgotPasswordClick = TODO()
        )
    }
}