@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.nectar.ui.theme.home

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nectar.R
import com.example.nectar.SearchScreenActivity
import com.example.nectar.data.model.dummy.BottomNavItem
import com.example.nectar.data.model.dummy.Product
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.account.AccountScreen
import com.example.nectar.ui.theme.cartScreen.CardScreen
import com.example.nectar.ui.theme.components.FilterButton
import com.example.nectar.ui.theme.explore.ExploreScreen
import com.example.nectar.ui.theme.explore.SearchBarforExplore
import com.example.nectar.ui.theme.explore.productList.ExploreScreenList
import com.example.nectar.ui.theme.explore.searchScreen.SearchScreen
import com.example.nectar.ui.theme.favourite.FavScreen
import com.example.nectar.ui.theme.shop.ShopScreenUI

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroceryHomeScreen(
    onProductClick: (Product) -> Unit = {}
) {
    var selectedNavItem by remember { mutableStateOf(0) }
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val categoryName = backStackEntry?.arguments?.getString("categoryName")


    LaunchedEffect(currentRoute) {
        Log.d("MainNavHost", "Navigated to: $currentRoute")
    }

    Log.d("currentRoute", currentRoute.toString())


    val bottomNavItems = listOf(
        BottomNavItem("Shop", R.drawable.store_1, selectedNavItem == 0),
        BottomNavItem("Explore", R.drawable.explore),
        BottomNavItem("Cart", R.drawable.cart),
        BottomNavItem("Favourite", R.drawable.fav),
        BottomNavItem("Account", R.drawable.user),
    )

    val primaryTextColor = Color(0xFF1D1D1D)

    Scaffold(
        modifier = Modifier.background(Color.White),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(
                        when (currentRoute) {
                            "Explore" -> 120.dp
                            "Account" -> 30.dp
                            else -> 100.dp
                        }
                    ),
                title = {
                    Column(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(start = 0.dp),
                        horizontalAlignment = if (currentRoute == "Cart") Alignment.Start else Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        when  {
                            (currentRoute == "Shop" || currentRoute == null) -> {
                                Image(
                                    painter = painterResource(id = R.drawable.carrot_color),
                                    contentDescription = "carrot icon",
                                    modifier = Modifier.size(30.dp)
                                )
                                Row(
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

                            // Replace the Explore section in your topBar with this code:

                            currentRoute == "Explore" -> {

                                Text(
                                    text = "Find Products",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = primaryTextColor,
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
                                )
                                Spacer(modifier = Modifier.height(10.dp))

                                SearchBarforExplore (
                                    onSearchClick = {
                                      val intent = Intent(navController.context,
                                          SearchScreenActivity::class.java)

                                        navController.context.startActivity(intent)

                                    }
                                )

                            }
                            currentRoute?.startsWith("ExploreScreenList/") == true -> {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(end = 25.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    IconButton(onClick = { navController.popBackStack() }) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                                            contentDescription = "Back",
                                            tint = Color.Black
                                        )
                                    }

                                    Text(
                                        text = categoryName ?: "Unknown",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = primaryTextColor,
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.weight(1f)
                                    )

                                    FilterButton()
                                }
                            }

                            currentRoute == "Cart" -> {
                                Text(
                                    text = "My Cart",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = primaryTextColor,
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth()
                                )

                                Spacer(modifier = Modifier.height(30.dp))

                                // Line
                                Row(
                                    modifier = Modifier.width(500.dp)
                                        .height(2.dp)
                                        .background(Color.Gray.copy(alpha = 0.3f)),
                                    content = {}
                                )
                            }

                            currentRoute == "Favourite" -> {
                                Text(
                                    text = "Favorurite",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = primaryTextColor,
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth()
                                )

                                Spacer(modifier = Modifier.height(30.dp))

                                // Line
                                Row(
                                    modifier = Modifier.width(500.dp)
                                        .height(2.dp)
                                        .background(Color.Gray.copy(alpha = 0.3f)),
                                    content = {}
                                )
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
            val currentSelectedIndex = when (currentRoute) {
                "Shop" -> 0
                "Explore" -> 1
                "Cart" -> 2
                "Favourite" -> 3
                "Account" -> 4
                else -> selectedNavItem
            }

            NavigationBar(
                containerColor = Color.White,
                modifier = Modifier.height(80.dp)
            ) {
                bottomNavItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = item.title,
                                    tint = if (index == currentSelectedIndex) Color(0xff4CAF50) else Color.Gray
                                )
                                Text(
                                    text = item.title,
                                    fontSize = 12.sp,
                                    color = if (index == currentSelectedIndex) Color(0xff4CAF50) else Color.Gray
                                )
                            }
                        },
                        selected = index == currentSelectedIndex,
                        onClick = {
                            selectedNavItem = index
                            navController.navigate(item.title) {
                                launchSingleTop = true
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                restoreState = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "Shop",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("Shop") { ShopScreenUI(onProductClick = onProductClick) }
            composable("Explore") { ExploreScreen(
                navController = navController,
                context = navController.context
            ) }
            composable("ExploreScreenList/{categoryName}") {
                backStackEntry ->
                ExploreScreenList(
                    navController = navController,
                    onProductClick = onProductClick,
                    onBackClick = { navController.popBackStack() }
                )
            }
            composable("SearchRoute") { SearchScreen() }
            composable("Cart") { CardScreen() }
            composable("Favourite") { FavScreen() }
            composable("Account") { AccountScreen() }
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
