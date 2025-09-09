package com.example.nectar

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.rememberNavController
import com.example.nectar.data.model.dummy.Product
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.explore.ExploreScreen
import com.example.nectar.ui.theme.explore.SearchBarforExplore
import com.example.nectar.ui.theme.explore.searchScreen.SearchScreen
import com.example.nectar.ui.theme.home.ProductDetailsScreen


class SearchScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            NectarTheme {
                SearchScreen()
            }
        }
    }
}
