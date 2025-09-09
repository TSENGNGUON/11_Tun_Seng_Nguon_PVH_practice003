package com.example.nectar.ui.theme.explore

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.ExploreListActivity
import com.example.nectar.ProductListActivity
import com.example.nectar.R
import com.example.nectar.data.model.dummy.CategoryItem
import com.example.nectar.ui.theme.components.CategoryCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(
    navController: NavHostController,
    context: Context
) {
    // Sample data for the categories
    val categories = listOf(
        CategoryItem("Fresh Fruits & Vegetable", R.drawable.daily, Color(0xFFE5F0E7)),
        CategoryItem("Cooking Oil & Ghee", R.drawable.cooking_oil, Color(0xFFFBF4E7)),
        CategoryItem("Meat & Fish", R.drawable.meat, Color(0xFFF9E8E8)),
        CategoryItem("Bakery & Snacks", R.drawable.bakery, Color(0xFFEAE5F1)),
        CategoryItem("Dairy & Eggs", R.drawable.egg, Color(0xFFF4F8EC)),
        CategoryItem("Beverages", R.drawable.drink, Color(0xFFE4F1F7))
    )

    val backStackEntry = navController.currentBackStackEntry
    val currentRoute = backStackEntry?.destination?.route
    val categoryName = backStackEntry?.arguments?.getString("categoryName")
    Log.d("currentRoute", currentRoute.toString())
    Log.d("currentRoute", "route=$currentRoute, category=$categoryName")

    Scaffold(
        modifier = Modifier.background(Color.White),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Search bar
//            SearchBarforExplore(
//                onSearchClick = {
//                    navController.navigate("SearchRoute")
//                    Log.d("ExploreScreen", "Search button clicked")
//                }
//            )

            Spacer(modifier = Modifier.height(20.dp))

            // Category Grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                contentPadding = PaddingValues(10.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(categories) { category ->
                    CategoryCard(
                        category = category,
                        navController = navController,
                        onCategoryItemClick = {
                            navController.navigate("ExploreScreenList/${category.name}")


                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExploreScreenPreview() {
    ExploreScreen(
        navController = rememberNavController(),
        context = LocalContext.current

    )
}