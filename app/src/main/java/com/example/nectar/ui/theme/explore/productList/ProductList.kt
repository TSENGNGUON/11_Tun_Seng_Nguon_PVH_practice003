    package com.example.nectar.ui.theme.explore.productList
    import androidx.compose.foundation.ExperimentalFoundationApi
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.PaddingValues
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.lazy.grid.GridCells
    import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
    import androidx.compose.foundation.lazy.grid.items
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Icon
    import androidx.compose.material3.IconButton
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
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
    import com.example.nectar.R
    import com.example.nectar.data.model.dummy.Product
    import com.example.nectar.ui.theme.components.FilterButton
    import com.example.nectar.ui.theme.components.ProductCard

    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
    @Composable
    fun ExploreScreenList(
        categoryName: String = "",
        onProductClick: (Product) -> Unit = {},
        onBackClick: () -> Unit = {},
        onfilterClick: () -> Unit = {}
    ) {
        val primaryTextColor = Color(0xFF1D1D1D)
        // Sample data for the categories
        val products = listOf(
            Product(
                id = "1",
                name = "Diet Coke",
                price = 1.99,
                imageRes = R.drawable.diet_coke,
                info = "355ml, Price",
            ),
            Product(
                id = "2",
                name = "Sprite Can",
                price = 1.50,
                imageRes = R.drawable.sprite_can,
                info = "325ml, Price",

                ),
            Product(
                id = "3",
                name = "Apple & Grape \n" +
                        "Juice",
                price = 15.99,
                imageRes = R.drawable.apple_grape_juice,
                info = "2L, Price",

                ),
            Product(
                id = "4",
                name = "Orenge Juice",
                price = 15.99,
                imageRes = R.drawable.orenge_juice,
                info = "2L, Price",

                ),
            Product(
                id = "5",
                name = "Coca Cola Can",
                price = 4.99,
                imageRes = R.drawable.coca_cola_can,
                info = "325ml, Price",
            ),
            Product(
                id = "6",
                name = "Pepsi Can",
                price = 4.99,
                imageRes = R.drawable.pepsi_can,
                info = "330ml, Price",

                )
        )
        var showBottomSheet by remember { mutableStateOf(false) }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = categoryName.ifEmpty { "Find Products" },
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = primaryTextColor,
                                fontSize = 20.sp
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { onBackClick() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                                contentDescription = "Back",
                            )
                        }
                    },
                    actions = {
                        FilterButton (

                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = Color.Black
                    )
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                // Product grid (sample data now, but you can filter by categoryName later)
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    items(products) {
                        ProductCard(it, onProductClick = onProductClick)
                    }
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun ExploreScreenListPreview() {
        ExploreScreenList()
    }


