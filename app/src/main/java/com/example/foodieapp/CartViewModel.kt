package com.example.foodieapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.foodieapp.datalayer.datamodel.CartItem

class CartViewModel : ViewModel() {
    // List to hold cart items
    val cartItems = mutableStateListOf<CartItem>()

    // Function to add items to the cart
    fun addItemToCart(item: CartItem) {
        cartItems.add(item)
    }

    // Calculate total cost of items in the cart
    fun getTotalCost(): Double {
        return cartItems.sumOf { it.quantity * it.price }
    }
}