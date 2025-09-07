package com.example.nectar.ui.theme.cartScreen


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
import androidx.compose.runtime.Composable
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
import com.example.nectar.ui.theme.components.CardItem

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CardScreen(
    navController:
    NavHostController  =
    rememberNavController()
) {

    val products = listOf(
        Product(
            id = "1",
            name = "Organic Bananas",
            price = 4.99,
            imageRes = R.drawable.banana,
            info = "7cs, Priceg",
            quantity = 0,
        ),
        Product(
            id = "2",
            name = "Organic Bananas",
            price = 4.99,
            imageRes = R.drawable.banana_2,
            info = "7cs, Priceg",
            quantity = 0,

            ),
        Product(
            id = "3",
            name = "Red Apple",
            price = 4.99,
            imageRes = R.drawable.apple_2_removebg,
            info = "1kg, Priceg",
            quantity = 0,

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
//    val groceries = listOf(
//        Product(
//            id = "1",
//            name = "Beef Bone",
//            price = 4.99,
//            imageRes = R.drawable.beef_bone,
//            info = "1kg, Priceg",
//        ),
//        Product(
//            id = "2",
//            name = "Broiler Chicket",
//            price = 4.99,
//            imageRes = R.drawable.chicket,
//            info = "1kg, Priceg",
//
//            ),
//        Product(
//            id = "3",
//            name = "Organic Bananas",
//            price = 4.99,
//            imageRes = R.drawable.banana_2,
//            info = "1kg, Priceg",
//
//            )
//    )




        //---------------------------------------------------
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, start = 20.dp, end = 20.dp),

            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(19.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF53B175)
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = "Go to Checkout",
                            modifier = Modifier
                                .padding(top = 10.dp, bottom = 10.dp),
                            fontWeight = FontWeight.SemiBold
                        )

                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .background(Color(0xFF489E67)
                                ),

                            ) {
                            Text(
                                text = "$12.96",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light,
                                modifier = Modifier
                                    .padding(
                                        vertical = 3.dp,
                                        horizontal = 3.dp
                                    ),

                                )
                        }
                    }

                }
            }

        }

    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            // Content of each Items

            items(products) {
                    cartItem ->

                CardItem(
                    product = cartItem,
                    onIncreaseQuantity = {
                        cartItem.quantity++

                    },
                    onDecreaseQuantity = {
                        if (cartItem.quantity > 0) {
                            cartItem.quantity--
                        }

                    }
                )



            }


        }

    }



}


@Preview(showBackground = true)
@Composable
fun CardScreenPreview() {
    CardScreen(
        navController = rememberNavController()
    )
}


