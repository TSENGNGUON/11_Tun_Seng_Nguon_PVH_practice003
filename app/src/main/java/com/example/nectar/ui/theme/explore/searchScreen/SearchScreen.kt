package com.example.nectar.ui.theme.explore.searchScreen
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
import com.example.nectar.ui.theme.components.SearchBarScreen

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onProductClick: (Product) -> Unit = {},
    onBackClick: () -> Unit = {},
    onfilterClick: () -> Unit = {}
) {

    // Sample data for the categories
    val products = listOf(
        Product(
            id = "1",
            name = "Egg Chicken Red",
            price = 1.99,
            imageRes = R.drawable.egg_chicken_red,
            info = "4pcs, Price",
        ),
        Product(
            id = "2",
            name = "Egg Chicken White",
            price = 1.50,
            imageRes = R.drawable.egg,
            info = "180g, Price",

            ),
        Product(
            id = "3",
            name = "Egg Pasta ",
            price = 15.99,
            imageRes = R.drawable.egg_pasta,
            info = "30gm, Price",

            ),
        Product(
            id = "4",
            name = "Egg Noodles",
            price = 15.99,
            imageRes = R.drawable.egg_noodles,
            info = "2L, Price",

            ),
        Product(
            id = "5",
            name = "Mayonnais Eggless",
            price = 4.99,
            imageRes = R.drawable.mayonnais_eggless,
            info = "325ml, Price",
        ),
        Product(
            id = "6",
            name = "Egg Noodles",
            price = 4.99,
            imageRes = R.drawable.egg_noodles2,
            info = "330ml, Price",

            )
    )
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                        contentAlignment = Alignment.Center

                    ) {
                        // Search bar
                        SearchBarScreen()
                    }
                },
                actions = {
                    FilterButton(

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
fun SearchScreenPreview() {
    SearchScreen()
}


