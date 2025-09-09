package com.example.nectar.ui.theme.favourite


import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.R
import com.example.nectar.data.model.dummy.Product
import com.example.nectar.ui.theme.components.AddToCartPopup
import com.example.nectar.ui.theme.components.CardItem
import com.example.nectar.ui.theme.favourite.components.FavCardItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FavScreen(
    navController: NavHostController = rememberNavController()
) {
    var showPopup by remember { mutableStateOf(false) }
    var isSuccess by remember { mutableStateOf(true) }
    var isLoading by remember { mutableStateOf(false) }

    val bestSelligProducts = listOf(
        Product(
            id = "1",
            name = "Sprite Can",
            price = 1.50,
            imageRes = R.drawable.sprite_can,
            info = "325ml, Price",
        ),
        Product(
            id = "2",
            name = "Diet Coke",
            price = 1.99,
            imageRes = R.drawable.diet_coke,
            info = "355ml, Price",
        ),
        Product(
            id = "3",
            name = "Apple & Grape Juice",
            price = 15.50,
            imageRes = R.drawable.apple_grape_juice,
            info = "2L, Price",
        ),
        Product(
            id = "4",
            name = "Coca Cola Can",
            price = 4.99,
            imageRes = R.drawable.coca_cola_can,
            info = "325ml, Price",
        ),
        Product(
            id = "5",
            name = "Pepsi Can",
            price = 4.99,
            imageRes = R.drawable.pepsi_can,
            info = "330ml, Price",
        )
    )

    // Function to simulate adding to cart
    suspend fun addAllToCart(): Boolean {
        delay(1000) // Simulate network call
        return kotlin.random.Random.nextBoolean() // Randomly succeed or fail for demo
    }

    //---------------------------------------------------
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                modifier = Modifier
                    .height(90.dp)
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, start = 20.dp, end = 20.dp),
            ) {
                Button(
                    onClick = {
                        if (!isLoading) {
                            isLoading = true
                            // Launch coroutine to handle the async operation
                            kotlinx.coroutines.CoroutineScope(kotlinx.coroutines.Dispatchers.Main).launch {
                                val result = addAllToCart()
                                isSuccess = result
                                showPopup = true
                                isLoading = false
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(19.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF53B175)
                    ),
                    enabled = !isLoading
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = if (isLoading) "Adding..." else "Add All To Cart",
                            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )

                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .background(Color(0xFF489E67)),
                        ) {
                            // You can add a cart icon or quantity indicator here
                        }
                    }
                }
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(bottom = 100.dp), // leave space so last item isn't hidden by bottom bar
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top // stack normally
        ) {
            items(bestSelligProducts) { favItem ->
                FavCardItem(
                    product = favItem,
                    onIncreaseQuantity = {},
                    onDecreaseQuantity = {}
                )
            }
        }
    }

    // Popup Dialog
    AddToCartPopup(
        showDialog = showPopup,
        onDismiss = { showPopup = false },
        onTryAgain = {
            showPopup = false
            // Retry adding to cart
            isLoading = true
            kotlinx.coroutines.CoroutineScope(kotlinx.coroutines.Dispatchers.Main).launch {
                val result = addAllToCart()
                isSuccess = result
                showPopup = true
                isLoading = false
            }
        },
        onBackToHome = {
            showPopup = false
            // Navigate back to home screen
            navController.popBackStack()
        },
        isSuccess = isSuccess
    )
}

@Preview(showBackground = true)
@Composable
fun FavScreenPreview() {
    FavScreen(
        navController = rememberNavController()
    )
}