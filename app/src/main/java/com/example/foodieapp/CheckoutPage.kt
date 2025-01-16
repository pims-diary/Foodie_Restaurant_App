package com.example.foodieapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodieapp.datalayer.datamodel.CartItem


@Composable
fun CheckoutPage(cartViewModel: CartViewModel) {
    val cartItems = cartViewModel.cartItems
    val totalCost = cartViewModel.getTotalCost()
    var isOrderPlaced by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f) // Take up available vertical space
        ) {
            items(cartItems) { item ->
                CheckoutItemRow(item = item)
            }
        }

        Text(
            text = "Total Cost: $${"%.2f".format(totalCost)}",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Button(
            onClick = { isOrderPlaced = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Place Order")
        }

        if (isOrderPlaced) {
            Text(
                text = "Order successfully placed!",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun CheckoutItemRow(item: CartItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(item.name, style = MaterialTheme.typography.bodySmall)
        Text("Qty: ${item.quantity}", style = MaterialTheme.typography.bodyMedium)
        Text("$${"%.2f".format(item.quantity * item.price)}", style = MaterialTheme.typography.bodyMedium)
    }
}
