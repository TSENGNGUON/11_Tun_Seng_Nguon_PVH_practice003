package com.example.nectar.ui.theme.explore

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nectar.R
import com.example.nectar.data.model.dummy.CategoryItem
import com.example.nectar.ui.theme.components.CategoryCard
import com.example.nectar.ui.theme.components.SearchBarScreen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import kotlin.math.log


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(
        navController: NavHostController  = rememberNavController()
) {

    val primaryTextColor = Color(0xFF1D1D1D)

    // Sample data for the categories
    val categories = listOf(
        CategoryItem("Fresh Fruits & Vegetable", R.drawable.daily, Color(0xFFE5F0E7)),
        CategoryItem("Cooking Oil & Ghee", R.drawable.cooking_oil, Color(0xFFFBF4E7)),
        CategoryItem("Meat & Fish", R.drawable.meat, Color(0xFFF9E8E8)),
        CategoryItem("Bakery & Snacks", R.drawable.bakery, Color(0xFFEAE5F1)),
        CategoryItem("Dairy & Eggs", R.drawable.egg, Color(0xFFF4F8EC)),
        CategoryItem("Beverages", R.drawable.drink, Color(0xFFE4F1F7)),
        CategoryItem("Dairy & Eggs", R.drawable.daily, Color(0xFFE4F1F7)),
        CategoryItem("Beverages", R.drawable.daily, Color(0xFFE4F1F7))
    )

    Scaffold(
        modifier = Modifier.background(Color.White),
    ) {
        Column(
            modifier = Modifier.padding(0.dp)
                .background(Color.White)
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            SearchBarScreen(
                onSearchClick = {
                    navController.navigate("SearchScreen1")
                    Log.d("ExploreScreen", "Search button clicked")
                }
            )
                Spacer(modifier = Modifier.height(20.dp))
                // Category Grid
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxWidth().background(Color.White),
                    contentPadding = PaddingValues(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    items(categories) { category ->
                        CategoryCard(category, onCategoryItemClick = {
                            navController.navigate("ExploreScreenList")
                        })
                    }


                }
            }


        }
    }


@Preview(showBackground = true)
@Composable
fun ExploreScreenPreview() {
    ExploreScreen(
        navController = rememberNavController()
    )
}


