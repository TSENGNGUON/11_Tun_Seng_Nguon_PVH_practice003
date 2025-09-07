package com.example.nectar.ui.theme.cartScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.data.model.dummy.Product

@Composable
fun QuantityUI (
    product: Product,
    onDecreaseQuantity: () -> Unit = {},
    onIncreaseQuantity: () -> Unit = {}
) {
    var quantity by remember { mutableStateOf(product.quantity) }
    Row(
        modifier = Modifier.width(100.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
        ) {
        //Minus Button
        IconButton(
            modifier = Modifier.size(20.dp)
                .border(1.dp, Color(0xffF0F0F0), RoundedCornerShape(17.dp)),
            onClick = {
                onDecreaseQuantity()
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_check_indeterminate_small_24),
                contentDescription = "- icon",
                tint = Color(0xff7C7C7C),
                modifier = Modifier.size(20.dp)
            )
        }

        //------------------------------------------------------------------------------

        Text(
            text = "${quantity}"
        )



        //Plus Button
        IconButton(
            modifier = Modifier.size(20.dp)
                .border(1.dp, Color(0xffF0F0F0), RoundedCornerShape(17.dp)),
            onClick = {
                onIncreaseQuantity()
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_add_24),
                contentDescription = "+ icon",
                tint = Color(0xff53B175),
                modifier = Modifier.size(20.dp)
            )
        }


    }

}

@Preview(showBackground = true)
@Composable
fun QuantityUIPre() {
    QuantityUI(
        product = Product( name = "Natural Red Apple",
            imageRes = R.drawable.apple_2_removebg,
            info = "1kg, Priceg",
            id = "1",
            price = 4.99,
            quantity = 1
    )
    )
}