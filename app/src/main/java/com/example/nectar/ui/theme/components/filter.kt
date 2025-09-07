package com.example.nectar.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterButton(onfilterClick: () -> Unit = {}){
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    // Example filter states
    var selectedCategory by remember { mutableStateOf("Eggs") }
    var selectedBrand by remember { mutableStateOf("Cocola") }
    IconButton(onClick = {
        showBottomSheet = true
    }) {
        Icon(
            painter = painterResource(id = R.drawable.filter),
            contentDescription = "Filter",
        )
    }
    if (showBottomSheet) {

            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                modifier = Modifier.padding(top = 10.dp)
            ) {

                LazyColumn(

                ){
                    item {
                        // Header
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = { showBottomSheet = false }) {
                                Icon(Icons.Default.Close, contentDescription = "Close")
                            }
                            Text("Filters", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Spacer(modifier = Modifier.width(40.dp)) // balance close button
                        }

                        // Categories
                        Text(
                            "Categories",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 4.dp)
                        )
                        val categories = listOf("Eggs", "Noodles & Pasta", "Chips & Crisps", "Fast Food")
                        categories.forEach { category ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 4.dp)
                            ) {
                                Checkbox(
                                    checked = selectedCategory == category,
                                    onCheckedChange = { selectedCategory = category },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = Color(0xFF53B175) // Green like your design
                                    )
                                )
                                Text(
                                    text = category,
                                    color = if (selectedCategory == category) Color(0xFF53B175) else Color.Black
                                )
                            }
                        }

                        // Brand
                        Text(
                            "Brand",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 4.dp)
                        )
                        val brands = listOf("Individual Collection", "Cocola", "Ifad", "Kazi Farmas")
                        brands.forEach { brand ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 4.dp)
                            ) {
                                Checkbox(
                                    checked = selectedBrand == brand,
                                    onCheckedChange = { selectedBrand = brand },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = Color(0xFF53B175)
                                    )
                                )
                                Text(
                                    text = brand,
                                    color = if (selectedBrand == brand) Color(0xFF53B175) else Color.Black
                                )
                            }
                        }
                        // Apply Filter Button
                        Button(
                            onClick = {
                                // TODO: Apply filter logic
                                showBottomSheet = false
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF53B175)
                            )
                        ) {
                            Text("Apply Filter", color = Color.White)
                        }
                    }
                }

            }




    }
}