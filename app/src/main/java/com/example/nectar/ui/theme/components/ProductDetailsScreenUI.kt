@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.nectar.ui.theme.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.data.model.dummy.BottomNavItem
import com.example.nectar.data.model.dummy.Product
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.components.BannerUI
import com.example.nectar.ui.theme.components.ProductCard
import com.example.nectar.ui.theme.components.PulesScreenUI
import com.example.nectar.ui.theme.components.SearchBarScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsScreen(
    product: Product = Product(
        name = "Natural Red Apple",
        imageRes = R.drawable.apple_2_removebg,
        info = "1kg, Priceg",
        id = "1",
        price = 4.99,
        quantity = 1
    ),
    onBackClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onAddToBasketClick: () -> Unit = {},
    onChangeDetails: () -> Unit = {}
) {

    var quantity by remember { mutableIntStateOf(product.quantity) }
    var isFavorited by remember { mutableStateOf(false) }
    var showProductDetail by remember { mutableStateOf(true) }

    Scaffold (
        topBar = {
            TopAppBar(
                modifier = Modifier.height(70.dp),
                navigationIcon = {

                    IconButton(onClick = {
                        onBackClick()
                    }) {
                        Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "back icon", modifier = Modifier.size(28.dp))
                    }

                },
                title = { Text("") }
                ,
                actions = {
                    IconButton(onClick = {}){
                        Icon(
                            painter = painterResource(
                              id= R.drawable.save,
                            )
                            , contentDescription = "save icon",
                            modifier = Modifier.size(18.dp))
                    }

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xffF2F3F2)
                        .copy(alpha = 0.6f))


            )
        },
        bottomBar = {
            Row (modifier = Modifier.background(Color.White)
                .fillMaxWidth().padding(bottom = 35.dp)
                .height(60.dp)){
                Button(
                    onClick = {  },
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).fillMaxHeight(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF53b175)
                    ),
                    shape = RoundedCornerShape(19.dp)
                ) {
                    Text("Add to basket",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White)

                }
            }
        }
    ){
            paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White),
            contentPadding = PaddingValues(0.dp, top = 0.dp),

        ) {
            // Card Image
           item {
               Card(
                   modifier = Modifier
                       .fillMaxSize(),
                   shape = RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 24.dp),
                   colors = CardDefaults.cardColors(
                       containerColor = Color(0xffF2F3F2)
                           .copy(alpha = 0.6f))
               ) {
                 Column(
                     modifier = Modifier
                         .fillMaxWidth().background(Color(0xffF2F3F2).copy(0.6f))

                 ) {
                     Image(
                         painter = painterResource(id = product.imageRes ?: R.drawable.apple_2_removebg),
                         contentDescription = product.name,
                         modifier = Modifier
                             .size(270.dp).align(Alignment.CenterHorizontally)
                     )
                 }
               }
           }
            item {
                ProductInfo(
                    product = product,
                    isFav = isFavorited,
                    onFavClick = {
                        isFavorited = !isFavorited
                    },
                    quantity = quantity,
                    onDecreaseQuantity = {
                        if (quantity >0){
                            quantity--
                        }
                    },
                    onIncreaseQuantity = {
                        quantity ++
                    },
                    onChangeDetails = {
                        showProductDetail = !showProductDetail
                    },
                    showDetails = showProductDetail


                )
            }

            item {
                Spacer(modifier = Modifier.height(10.dp))
            }






        }
    }

}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductDetailsScreenPreview() {
    ProductDetailsScreen()
}


@Composable
fun ProductInfo(
    product: Product,
    isFav: Boolean,
    onFavClick: () -> Unit,
    quantity: Int,
    onIncreaseQuantity: () -> Unit = {},
    onDecreaseQuantity: () -> Unit = {},
    showDetails: Boolean ,
    onChangeDetails: () -> Unit = {}
){

    Column(modifier = Modifier.padding(horizontal = 20.dp).padding(top = 24.dp)) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text("${product.name}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp)
            IconButton(onClick = {
                onFavClick()
            }){
                Icon(
                    imageVector = if (isFav) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "fav icon",
                    tint = if (isFav)  Color.Red  else Color(color = 0xff7C7C7C),
                    modifier = Modifier.size(30.dp)
                )
            }
        }
        Text("${product.info}", color = Color(0xff7C7C7C), fontSize = 16.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Row (modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,){
            Row(modifier = Modifier.width(150.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                IconButton(onClick = {
                    onDecreaseQuantity()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_check_indeterminate_small_24),
                        contentDescription = "- icon",
                        tint = Color(0xff7C7C7C),
                        modifier = Modifier.size(30.dp)
                    )
                }
                Card(modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .background(Color.Transparent)
                    .border(1.dp, Color(0xff7C7C7C)
                        .copy(alpha = 0.6f),
                        RoundedCornerShape(16.dp)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    )
                    ){
                    Column(horizontalAlignment =
                        Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Text("$quantity",
                            fontSize = 20.sp, fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center)
                    }
                }
                IconButton(onClick = {
                    onIncreaseQuantity()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_add_24),
                        contentDescription = "+ icon",
                        tint = Color(0xff53B175),
                        modifier = Modifier.size(24.dp)
                    )
                }
                
                
            }
            Text("$${product.price}",
                fontSize = 30.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 5.dp))

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.width(500.dp)
                .height(1.dp)
                .background(Color.Gray.copy(alpha = 0.3f))
        ) {

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Product Details" , fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            IconButton(onClick = {
                onChangeDetails()
            }){
                if (showDetails) {
                    Icon(Icons.Default.KeyboardArrowUp, contentDescription = "down arrow",
                        modifier = Modifier.size(28.dp))
                }else{
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "down arrow",
                        modifier = Modifier.size(28.dp))
                }
            }
        }
        if (showDetails){
            Row(modifier =
                Modifier.fillMaxWidth()
                    .height(100.dp).
            padding(bottom = 2.dp)) {
                Text(text = "${product.detials}",
                    fontSize = 16.sp, color = Color(0xff7C7C7C))
            }
        }else{
            Row {
                Text("")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.width(500.dp)
                .height(1.dp)
                .background(Color.Gray.copy(alpha = 0.3f))
        ) {

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "${product.info}" , fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            Column(
                modifier =
                    Modifier
                        .background(Color(0xff7C7C7C)
                            .copy(alpha = 0.2f), shape = RoundedCornerShape(10.dp)),
            ){
                Text(text = "100gr" ,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray.copy(alpha = 1f),
                            modifier =
                            Modifier.padding(6.dp),
                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.width(500.dp)
                .height(1.dp)
                .background(Color.Gray.copy(alpha = 0.3f))
        ) {

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Review" , fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            Row {
                Icon(Icons.Default.Star,
                    contentDescription = "Star Icon", tint = Color(0xffF3603F))
                Icon(Icons.Default.Star,
                    contentDescription = "Star Icon", tint = Color(0xffF3603F))
                Icon(Icons.Default.Star,
                    contentDescription = "Star Icon", tint = Color(0xffF3603F))
                Icon(Icons.Default.Star,
                    contentDescription = "Star Icon", tint = Color(0xffF3603F))
                Icon(Icons.Default.Star,
                    contentDescription = "Star Icon", tint = Color(0xffF3603F))
            }
        }



    }

}


