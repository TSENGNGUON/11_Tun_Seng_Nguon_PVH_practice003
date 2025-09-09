package com.example.nectar

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.example.nectar.data.model.dummy.Product
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.explore.ExploreScreen
import com.example.nectar.ui.theme.explore.productList.ExploreScreenList
import com.example.nectar.ui.theme.home.ProductDetailsScreen


class ProductListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            NectarTheme {
                ExploreScreenList(
                    onBackClick = {
                        val intent = Intent(this, ExploreListActivity::class.java)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}
