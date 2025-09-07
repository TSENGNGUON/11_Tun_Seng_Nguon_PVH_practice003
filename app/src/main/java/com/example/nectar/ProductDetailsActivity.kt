package com.example.nectar

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.example.nectar.data.model.dummy.Product
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.home.ProductDetailsScreen


class ProductDetailsActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val product: Product? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("product", Product::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("product")
        }

        setContent {
            NectarTheme {
                product?.let {
                    ProductDetailsScreen(
                        product = it,
                        onBackClick = { finish() },
                        onShareClick = { /* TODO */ },
                        onAddToBasketClick = { /* TODO */ }
                    )
                }
            }
        }
    }
}
