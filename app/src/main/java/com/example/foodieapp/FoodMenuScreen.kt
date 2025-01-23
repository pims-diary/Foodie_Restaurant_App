package com.example.foodieapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FoodMenuScreen(foodViewModel: FoodViewModel = viewModel()) {
    // Collect state from ViewModel
    val foodItems by foodViewModel.foodItems.collectAsState(initial = emptyList())
    val isLoading by foodViewModel.isLoading.collectAsState()

    // Trigger the API fetch when the screen is displayed
    LaunchedEffect(Unit) {
        foodViewModel.fetchFoodItems()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        } else {
            if (foodItems.isNotEmpty()) {
                foodItems.forEach { foodItem ->
                    Text(text = "Name: ${foodItem.name}", modifier = Modifier.padding(8.dp))
                    Text(text = "Description: ${foodItem.descrip}", modifier = Modifier.padding(8.dp))
                    Text(text = "Price: ${foodItem.price}", modifier = Modifier.padding(8.dp))
                    Divider(modifier = Modifier.padding(8.dp))
                }
            } else {
                Text(text = "No items found", modifier = Modifier.padding(16.dp))
            }
        }
    }
}
