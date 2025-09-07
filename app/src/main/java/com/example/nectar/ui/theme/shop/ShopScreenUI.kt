package com.example.nectar.ui.theme.shop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.R
import com.example.nectar.data.model.dummy.Product
import com.example.nectar.ui.theme.components.BannerUI
import com.example.nectar.ui.theme.components.ProductCard
import com.example.nectar.ui.theme.components.PulesScreenUI
import com.example.nectar.ui.theme.components.SearchBarScreen
import com.example.nectar.ui.theme.home.SectionHeader

@Composable
fun ShopScreenUI(onProductClick: (Product) -> Unit = {}){
    val products = listOf(
        Product(
            id = "1",
            name = "Organic Bananas",
            price = 4.99,
            imageRes = R.drawable.banana,
            info = "7cs, Priceg",
        ),
        Product(
            id = "2",
            name = "Organic Bananas",
            price = 4.99,
            imageRes = R.drawable.banana_2,
            info = "7cs, Priceg",

            ),
        Product(
            id = "3",
            name = "Red Apple",
            price = 4.99,
            imageRes = R.drawable.apple_2_removebg,
            info = "1kg, Priceg",

            )
    )
    val bestSelligProducts = listOf(
        Product(
            id = "1",
            name = "Bell Pepper Red",
            price = 4.99,
            imageRes = R.drawable.tomato,
            info = "1kg, Priceg",
        ),
        Product(
            id = "2",
            name = "Ginger",
            price = 4.99,
            imageRes = R.drawable.ginger,
            info = "250gm, Priceg",

            ),
        Product(
            id = "3",
            name = "Organic Bananas",
            price = 4.99,
            imageRes = R.drawable.banana_2,
            info = "1kg, Priceg",

            )
    )
    val groceries = listOf(
        Product(
            id = "1",
            name = "Beef Bone",
            price = 4.99,
            imageRes = R.drawable.beef_bone,
            info = "1kg, Priceg",
        ),
        Product(
            id = "2",
            name = "Broiler Chicket",
            price = 4.99,
            imageRes = R.drawable.chicket,
            info = "1kg, Priceg",

            ),
        Product(
            id = "3",
            name = "Organic Bananas",
            price = 4.99,
            imageRes = R.drawable.banana_2,
            info = "1kg, Priceg",

            )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Search Bar
        item {
            SearchBarScreen()
        }



        //Banner
        item() {
            Spacer(modifier = Modifier.height(10.dp))
            BannerUI()
        }
        // Exclusive Offer Section
        item {
            SectionHeader(title = "Exclusive Offer", onSeeAllClick = { })
        }
        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 2.dp),
                horizontalArrangement = Arrangement.spacedBy(30.dp), // spacing between items
                modifier = Modifier.fillMaxWidth().padding(start = 0.dp),

                ) {
                items(
                    products
                ){ p ->
                    ProductCard(
                        product = p,
                        onProductClick = onProductClick
                    )

                }
            }
        }


        //Best Selling
        item {
            SectionHeader(title = "Best Selling", onSeeAllClick = { })
        }
        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 2.dp),
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier.fillMaxWidth().padding(start = 0.dp),

                ) {
                items(
                    bestSelligProducts
                ){ p ->
                    ProductCard(
                        product = p,
                        onProductClick = onProductClick
                    )

                }
            }
        }

        //Groceries
        item { SectionHeader(title = "Groceries") { } }

        item {
            LazyRow() {
                item {
                    PulesScreenUI(t = "Pulses", imageRes = R.drawable.pulses, color = Color(0xFFF8A44C)
                    )
                }
                item {
                    PulesScreenUI(t = "Rice ", imageRes = R.drawable.rice, color = Color(0xFF53B175)
                    )
                }

            }
        }

        // groceries product
        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 2.dp),
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier.fillMaxWidth().padding(start = 0.dp),
            ) {
                items(
                    groceries
                ){ p ->
                    ProductCard(
                        product = p,
                        onProductClick = onProductClick
                    )
                }

            }
        }

    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShopScreen() {
    ShopScreenUI()
}