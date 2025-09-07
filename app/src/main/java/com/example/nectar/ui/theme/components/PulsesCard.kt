@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.nectar.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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


@Composable
fun PulesScreenUI(imageRes: Int, t: String, color: Color = Color.Transparent){
    Card(
        modifier = Modifier.width(250.dp).padding(end = 12.dp)
            .height(120.dp).background(color.copy(alpha = 0.2f), shape = RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp)

    ) {
        Row( modifier = Modifier.fillMaxSize().background(color.copy(alpha = 0.2f)),
            verticalAlignment = Alignment.CenterVertically,


            ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "icon",
                modifier = Modifier.size(100.dp).padding(start = 24.dp)
            )
            Spacer(modifier = Modifier.width(24.dp))
            Text(text = t,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,)
        }
        
    }
}


@Preview(showBackground = true)
@Composable
fun PulesScreenUIPreview(){
    PulesScreenUI(
        imageRes = R.drawable.banana,
        t = "Test",
        color = Color(0xFFF8A44C
        )

    )
}