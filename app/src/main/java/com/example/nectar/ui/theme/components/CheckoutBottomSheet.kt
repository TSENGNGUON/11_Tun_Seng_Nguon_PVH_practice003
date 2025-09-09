package com.example.nectar.ui.theme.components

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import com.example.nectar.OrderAcceptedActivity
import com.example.nectar.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutBottomSheet(
    onDismiss: () -> Unit,
    onPlaceOrder: () -> Unit
) {
    val context = LocalContext.current

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Top bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Checkout", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                IconButton(onClick = { onDismiss() }) {
                    Icon(Icons.Default.Close, contentDescription = "Close")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Delivery
            CheckoutRow(title = "Delivery", value = "Select Method") {
                Toast.makeText(context, "Select delivery method", Toast.LENGTH_SHORT).show()
            }

            // Payment row with icon instead of text
            CheckoutRow(
                title = "Payment",
                value = null, // don’t pass text
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_visa),
                        contentDescription = "Visa",
                        tint = Color.Unspecified, // keeps original colors
                        modifier = Modifier.size(28.dp)
                    )
                }
            ) {
                Toast.makeText(context, "Choose payment method", Toast.LENGTH_SHORT).show()
            }

            // Promo Code
            CheckoutRow(title = "Promo Code", value = "Pick discount") {
                Toast.makeText(context, "Pick promo code", Toast.LENGTH_SHORT).show()
            }

            // Total cost
            CheckoutRow(title = "Total Cost", value = "$13.97", showArrow = false)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "By placing an order you agree to our Terms And Conditions",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))



            Button(
                onClick = {
                    onDismiss()
                    context.startActivity(
                        Intent(context, OrderAcceptedActivity::class.java)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
            ) {
                Text("Place Order")
            }
        }
    }
}

@Composable
fun CheckoutRow(
    title: String,
    value: String? = null,
    icon: (@Composable () -> Unit)? = null,
    showArrow: Boolean = true,
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = onClick != null) { onClick?.invoke() }
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, fontSize = 16.sp)

        Row(verticalAlignment = Alignment.CenterVertically) {
            // Show either text or icon
            if (value != null) {
                Text(value, fontSize = 16.sp, color = Color.Gray)
            } else if (icon != null) {
                icon()
            }

            if (showArrow) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}
