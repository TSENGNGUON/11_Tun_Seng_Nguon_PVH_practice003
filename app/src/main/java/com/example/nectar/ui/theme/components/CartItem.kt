package com.example.nectar.ui.theme.components

import android.graphics.BitmapFactory
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.data.model.dummy.Product
import com.example.nectar.ui.theme.cartScreen.components.QuantityUI


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardItem(
    product: Product,
    onIncreaseQuantity:  () -> Unit = {},
    onDecreaseQuantity:  () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Color.White)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {

            },

    ) {
        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            // Product Image Placeholder
            Box(
                modifier = Modifier.size(70.dp),
                contentAlignment = Alignment.Center
            ) {

                product.imageRes?.let {
                        resId ->
                    Image(
                        painter = painterResource(id = resId),
                        contentDescription = product.name,
                        modifier = Modifier.fillMaxSize()
                    )
                }

            }

            Spacer(modifier = Modifier.height(8.dp))


            //Center Content
            Row(
                modifier =
                    Modifier
                        .padding(start = 20.dp)
                        .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    // Product Name
                    Text(
                        text = "${product.name}",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center,

                        )

                    // addition info

                    Text(
                        text = "${product.info}",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(vertical = 2.dp)
                    )
                    // Quantity
                    Spacer(modifier = Modifier.height(30.dp))

                    QuantityUI(
                        product = product,
                        onIncreaseQuantity = onIncreaseQuantity,
                        onDecreaseQuantity = onDecreaseQuantity
                    )
                }

                //------------------------
                // Close Button and Price
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,

                ) {
                    IconButton(
                        onClick = {},

                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "Close",
                            tint = Color(0xff7C7C7C),


                        )
                    }

                    Spacer(modifier = Modifier.height(50.dp))

                    //Price
                    Text(
                        text = "$${product.price}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier.fillMaxHeight()

                    )
                }


            }




        }





    }
    Spacer(modifier = Modifier.height(20.dp))
    // Line
    Row(
        modifier = Modifier.width(500.dp)
            .height(1.dp)
            .background(Color.Gray.copy(alpha = 0.3f)),
        content = {}
    )
}





@Preview(showBackground = true)
@Composable
fun CardItemPreview() {
    CardItem(
        product = Product( name = "Natural Red Apple",
            imageRes = R.drawable.apple_2_removebg,
            info = "1kg, Priceg",
            id = "1",
            price = 4.99,
            quantity = 1),
        onIncreaseQuantity = {},
        onDecreaseQuantity = {

        }
    )
}