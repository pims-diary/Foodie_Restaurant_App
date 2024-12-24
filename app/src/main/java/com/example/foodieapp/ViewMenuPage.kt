package com.example.foodieapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ViewMenuPage(cartViewModel: CartViewModel) {
    val sampleMenu = listOf(
        MenuItem(
            title = "Biryani",
            description = "Aromatic rice dish with spices and meat.",
            price = 12.99
        ),
        MenuItem(
            title = "Pizza",
            description = "Cheesy pizza with fresh toppings.",
            price = 9.99
        ),
        MenuItem(
            title = "Fish and chips",
            description = "4 pieces of Beer battered crispy Snapper fillet along with fries with garlic and chive sauce.",
            price = 20.9
        ),
        MenuItem(
            title = "Soupy dumplings",
            description = "12 chicken and chives steamed dumplings",
            price = 18.5
        ),
        MenuItem(
            title = "Pan-fried dumplings",
            description = "12 chicken and chives pan fried dumplings",
            price = 19.0
        ),
        MenuItem(
            title = "Mixed fried rice",
            description = "Chinese style fried rice with eggs, chicken, crab meat and veggies",
            price = 21.9
        ),
        MenuItem(
            title = "Chilli chicken",
            description = "8 pieces of Sour and spicy indo style chilli chicken",
            price = 25.0
        )
    )

    LazyColumn(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(top = 105.dp)
    ) {
        items(sampleMenu.size) { itemNumber ->
            MenuItemCard(sampleMenu[itemNumber], cartViewModel)
            Spacer(modifier = Modifier.height(16.dp)) // Add spacing between items
        }
    }
}

@Composable
fun MenuItemCard(menuItem: MenuItem, cartViewModel: CartViewModel) {
    var quantity by remember { mutableStateOf("1") } // Default quantity is 1

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Menu item details
            Text(
                text = menuItem.title
            )
            Text(
                text = menuItem.title,
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = menuItem.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF142BB4)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$${menuItem.price}",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Row for quantity and button
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Quantity input
                OutlinedTextField(
                    value = quantity,
                    onValueChange = {
                        if (it.all { char -> char.isDigit() }) {
                            quantity = it
                        }
                    },
                    label = { Text("Quantity") },
                    singleLine = true,
                    modifier = Modifier.width(100.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                // Add to Cart Button
                Button(
                    onClick = {
                        val qty = quantity.toIntOrNull() ?: 0
                        if (qty > 0) {
                            cartViewModel.addItemToCart(CartItem(menuItem.title, qty, menuItem.price))
                            quantity = ""
                        }
                    }
                ) {
                    Text("Add to Cart")
                }
            }
        }
    }
}