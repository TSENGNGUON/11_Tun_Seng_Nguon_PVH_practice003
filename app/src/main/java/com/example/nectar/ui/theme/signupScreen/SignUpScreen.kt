package com.example.nectar.ui.theme.signupScreen

import android.content.Context
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import com.google.accompanist.flowlayout.FlowRow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(
    onLoginClick: (context: Context) -> Unit,
    onSignUpClick: () -> Unit = {},
    onTermClick: () -> Unit = {},
    onPrivacyPolicyClick: () -> Unit = {},
) {
    var username by remember { mutableStateOf("Seng Tra") }
    var email by remember { mutableStateOf("sengn5112@gmail.com") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val ctx = LocalContext.current
    

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFCFCFC))
            .padding(start = 24.dp, end = 24.dp, bottom = 50.dp )
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start

    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(id = R.drawable.carrot_color),
            contentDescription = "Carrot Logo",
            modifier = Modifier.size(48.dp).align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(50.dp))

        //Login Title
        Text(
            text = "Sign Up",
            fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF181725)
        )
        Spacer(modifier = Modifier.height(8.dp))
        //Subtitle
        Text(
            text = "Enter your credentials to continue",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF7c7c7c)
        )
        Spacer(modifier = Modifier.height(40.dp))
        // Username Field
        Text(
            text = "Username",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF7c7c7c),
            modifier = Modifier.padding(bottom = 8.dp)

        )
        OutlinedTextField(
            value = username,
            onValueChange = {username = it},
            placeholder = {
                Text("Enter your username",
                    color = Color(0xFF7c7c7c))

            },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF53B175),
                unfocusedBorderColor = Color(0xFFE2E2E2),
                focusedTextColor = Color(0xFF181725),
                unfocusedTextColor = Color(0xFF181725)
            ),
            singleLine = true,
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
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
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.check),
                    contentDescription = "Email Verified",
                    tint = Color(0xff53b175),
                    modifier = Modifier.size(20.dp)
                )
            },
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

        Spacer(modifier = Modifier.height(10.dp))
        // Term and privacy policy text

        FlowRow(
                modifier = Modifier.fillMaxWidth(),
                mainAxisSpacing = 4.dp,
                crossAxisSpacing = 0.dp

        ) {
            Text(
                text = "By continuing you agree to our",
                fontSize = 12.sp,
                color = Color(0xFF7C7C7C)
            )

            Text(
                text = "Terms of Service",
                fontSize = 12.sp,
                color = Color(0xFF53B175),
                modifier = Modifier.clickable { onTermClick() }
            )

            Text(
                text = " and",
                fontSize = 12.sp,
                color = Color(0xFF7C7C7C)
            )

            Text(
                text = "Privacy Policy",
                fontSize = 12.sp,
                color = Color(0xFF53B175),
                modifier = Modifier.clickable { onPrivacyPolicyClick() }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        // Sign up Button
        Button(
            onClick =  onSignUpClick,
            modifier = Modifier.fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF53b175)
            ),
            shape = RoundedCornerShape(19.dp)
        ) {
            Text("Sign Up",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White)

        }

        Spacer(modifier = Modifier.height(16.dp))

        // Login text

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Already have an account? ",
                fontSize = 14.sp,
                color = Color(0xff181725)
            )
            Text(
                text = "Login",
                fontSize = 14.sp,
                color = Color(0xff53b175),
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable {
                    onLoginClick(ctx)
                }
            )
        }


    }

}


@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
   
    NectarTheme {
        SignupScreen(
            onLoginClick = { },
        )
    }
}