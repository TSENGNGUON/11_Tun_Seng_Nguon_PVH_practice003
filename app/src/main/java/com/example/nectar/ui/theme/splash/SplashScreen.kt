package com.example.nectar.ui.theme.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.ui.theme.NectarTheme

@Composable
fun ComposeScreen() {
    Box(modifier = Modifier.fillMaxSize().background(Color(0xFF53B175))
    ){
        Row(modifier =
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Icon(
                painter = painterResource(R.drawable.carrot),
                contentDescription = "splash card icon",
                tint = Color(0xFFFFFFFF),
                modifier = Modifier.size(60.dp)
            )
            Text("nectar",
                color = Color(0xFFFFFFFF),
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
//                fontFamily = poppins,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}

@Preview
@Composable
fun ComposeScreenPreview() {
    NectarTheme {
        ComposeScreen()
    }
}