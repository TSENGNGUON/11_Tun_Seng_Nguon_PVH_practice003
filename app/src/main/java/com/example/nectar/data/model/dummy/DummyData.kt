package com.example.nectar.data.model.dummy

import android.os.Parcelable
import androidx.compose.ui.graphics.Color
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val imageRes: Int? = null,
    val info: String,
    val detials: String= "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart.",
    var quantity: Int = 0,
    var isFavorite: Boolean = false
): Parcelable



data class CategoryItem(
    val name: String,
    val imageRes: Int? = null,
    val backgroundColor: Color,
)



data class BottomNavItem(
    val title: String,
    val icon: Int,
    val isSelected: Boolean = false
)


