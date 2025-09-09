package com.example.nectar.ui.theme.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBarScreen(
    searchText: String = "",
    onSearchTextChange: (String) -> Unit = {},
    onSearchSubmit: (String) -> Unit = {},
    placeholder: String = "Search Store"
) {
    var internalSearchText by remember { mutableStateOf(searchText) }

    TextField(
        value = if (searchText.isNotEmpty()) searchText else internalSearchText,
        onValueChange = { newText ->
            if (searchText.isEmpty()) {
                internalSearchText = newText
            }
            onSearchTextChange(newText)
        },
        placeholder = {
            Text(placeholder, color = Color.Gray)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.Gray
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = androidx.compose.ui.text.input.ImeAction.Search
        ),
        keyboardActions = androidx.compose.foundation.text.KeyboardActions(
            onSearch = {
                val textToSubmit = if (searchText.isNotEmpty()) searchText else internalSearchText
                onSearchSubmit(textToSubmit)
            }
        ),
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFFF1F2F1),
            focusedContainerColor = Color(0xFFF1F2F1),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Black
        ),
        singleLine = true
    )
}

// Example usage with state management
@Composable
fun SearchBarWithState() {
    var searchText by remember { mutableStateOf("") }

    SearchBarScreen(
        searchText = searchText,
        onSearchTextChange = { searchText = it },
        onSearchSubmit = { query ->
            // Handle search submission
            println("Searching for: $query")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarScreenPreview() {
    SearchBarWithState()
}