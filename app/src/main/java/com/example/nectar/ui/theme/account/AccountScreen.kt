package com.example.nectar.ui.theme.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(
    navController: NavHostController = rememberNavController()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(Color.White)
    ) {
        // Status Bar Space
        Spacer(modifier = Modifier.height(40.dp))

        // Title
        Text(
            text = "Account",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
        )

        // Profile Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Profile Image
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE8F5E8))
            ) {
                // You can replace this with actual profile image
                Image(
                    painter = painterResource(id = R.drawable.profile_avatar), // Add your profile image
                    contentDescription = "Profile Picture",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Penh Seyha",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        Icons.Default.Edit,
                        contentDescription = "Edit Profile",
                        tint = Color(0xFF53B175),
                        modifier = Modifier.size(20.dp)
                    )
                }
                Text(
                    text = "penhseyha980@gmail.com",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        Divider(
            color = Color(0xFFE2E2E2),
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        // Menu Items
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))

                AccountMenuItem(
                    icon = painterResource(id = R.drawable.shoppingbag),
                    title = "Orders",
                    onClick = { /* Navigate to orders */ }
                )

                AccountMenuItem(
                    icon = painterResource(id = R.drawable.person),
                    title = "My Details",
                    onClick = { /* Navigate to details */ }
                )

                AccountMenuItem(
                    icon = painterResource(id = R.drawable.locationon),
                    title = "Delivery Address",
                    onClick = { /* Navigate to delivery address */ }
                )

                AccountMenuItem(
                    icon = painterResource(id = R.drawable.creditcard),
                    title = "Payment Methods",
                    onClick = { /* Navigate to payment methods */ }
                )

                AccountMenuItem(
                    icon = painterResource(id = R.drawable.localoffer),
                    title = "Promo Card",
                    onClick = { /* Navigate to promo card */ }
                )

                AccountMenuItem(
                    icon = painterResource(id = R.drawable.notifications),
                    title = "Notifications",
                    onClick = { /* Navigate to notifications */ }
                )

                AccountMenuItem(
                    icon = painterResource(id = R.drawable.help),
                    title = "Help",
                    onClick = { /* Navigate to help */ }
                )

                AccountMenuItem(
                    icon = painterResource(id = R.drawable.info),
                    title = "About",
                    onClick = { /* Navigate to about */ },
                    showDivider = false
                )

                Spacer(modifier = Modifier.height(20.dp))
            }
        }

        // Logout Button
        Button(
            onClick = { /* Handle logout */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(horizontal = 20.dp)
                .padding(bottom = 30.dp),
            shape = RoundedCornerShape(19.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF2F3F2)
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    Icons.Default.ExitToApp,
                    contentDescription = "Logout",
                    tint = Color(0xFF53B175),
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Log Out",
                    color = Color(0xFF53B175),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun AccountMenuItem(
    icon: Painter,
    title: String,
    onClick: () -> Unit,
    showDivider: Boolean = true
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                icon,
                contentDescription = title,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )

            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "Arrow Right",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }

        if (showDivider) {
            Divider(
                color = Color(0xFFE2E2E2),
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
    AccountScreen(
        navController = rememberNavController()
    )
}