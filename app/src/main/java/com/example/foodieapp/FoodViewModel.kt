package com.example.foodieapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodieapp.datalayer.datamodel.FoodItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FoodViewModel : ViewModel() {
    private val repository = FoodRepository()

    private val _foodItems = MutableStateFlow<List<FoodItem>>(emptyList())
    val foodItems: StateFlow<List<FoodItem>> = _foodItems

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchFoodItems()
    }

    fun fetchFoodItems() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // Fetch the data from the repository
                _foodItems.value = repository.getFoodItems()
                // Update the value of the StateFlow
//                _foodItems.value = foodList
                println("Data fetched successfully")
                println(_foodItems.value)
            } catch (e: Exception) {
                // Handle error
                println("Error fetching food items: $e")
            } finally {
                _isLoading.value = false
            }
        }
    }
}
