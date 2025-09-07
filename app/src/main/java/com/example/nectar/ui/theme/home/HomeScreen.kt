@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.nectar.ui.theme.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nectar.R
import com.example.nectar.data.model.dummy.BottomNavItem
import com.example.nectar.data.model.dummy.Product
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.cartScreen.CardScreen
import com.example.nectar.ui.theme.explore.ExploreScreen
import com.example.nectar.ui.theme.explore.productList.ExploreScreenList
import com.example.nectar.ui.theme.explore.searchScreen.SearchScreen
import com.example.nectar.ui.theme.favourite.FavScreen
import com.example.nectar.ui.theme.shop.ShopScreenUI



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroceryHomeScreen(onProductClick: (Product) -> Unit = {}) {
    var selectedNavItem by remember { mutableStateOf(0) }
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntry?.destination?.route

    val bottomNavItems = listOf(
        BottomNavItem("Shop", R.drawable.store_1, selectedNavItem == 0 ),
        BottomNavItem("Explore", R.drawable.explore, ),
        BottomNavItem("Cart", R.drawable.cart),
        BottomNavItem("Favourite",R.drawable.fav),
        BottomNavItem("Account",R.drawable.user),
    )
    val primaryTextColor = Color(0xFF1D1D1D)

    Scaffold (
        modifier = Modifier.background(Color.White),
        topBar = {
            TopAppBar(
                modifier = Modifier.height(100.dp),
                title = {
                    Column(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                       ) {

                        when(currentRoute) {
                            "Shop", null -> {
                                Image(
                                    painter = painterResource(id = R.drawable.carrot_color),
                                    contentDescription = "carrot icon",
                                    modifier = Modifier.size(30.dp)
                                )
                                Row (
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.LocationOn,
                                        contentDescription = "location icon",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "Dhaka, Banassre",
                                        color = Color.Black,
                                        fontSize = 14.sp

                                    )
                                }
                            }
                            "Explore" -> {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Find Products",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = primaryTextColor,
                                        fontSize = 20.sp
                                    )
                                }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
                            }

                        }






                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                modifier = Modifier.height(80.dp)
            ){
                bottomNavItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = item.title,
                                    tint = if (item.isSelected) Color(0xff4CAF50) else Color.Gray
                                )
                                Text(
                                    text = item.title,
                                    fontSize = 12.sp,
                                    color = if (item.isSelected) Color(0xff4CAF50) else Color.Gray
                                )

                            }

                        },
                        selected = index == selectedNavItem,
                        onClick = {
                            selectedNavItem = index
                            // Navigate to route
                            navController.navigate(item.title){
                                launchSingleTop = true
                                popUpTo (
                                    navController.graph.startDestinationId
                                )
                            }
                                  },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ){
        paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "Shop",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("Shop") { ShopScreenUI(onProductClick = onProductClick) }
            composable("Explore") { ExploreScreen(navController = navController) }
            composable("ExploreScreenList")
            {ExploreScreenList()
            }
            composable("SearchScreen1") { SearchScreen()}
            composable("Cart") { CardScreen() }
            composable("Favourite"){ FavScreen() }
        }

    }
    }




@Composable
fun SectionHeader(
    title: String,
    onSeeAllClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        TextButton(onClick = onSeeAllClick) {
            Text(
                text = "See all",
                color = Color(0xFF4CAF50),
                fontSize = 14.sp
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GeryHomeScreenPreview() {
    NectarTheme {
        GroceryHomeScreen(
            onProductClick = {},
        )
    }
}