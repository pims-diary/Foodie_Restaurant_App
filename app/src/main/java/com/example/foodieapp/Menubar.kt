package com.example.foodieapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MenuBar() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var currentPage by remember { mutableIntStateOf(0) }

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

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(Modifier.height(12.dp))
                    Text("Welcome to Foodie", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleLarge)
                    HorizontalDivider()

                    Text("Menu", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleMedium)
                    NavigationDrawerItem(
                        label = { Text("View menu") },
                        selected = false,
                        icon = { Icon(Icons.Outlined.Add, contentDescription = null) },
                        onClick = {
                            currentPage = 1
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text("Checkout") },
                        selected = false,
                        icon = { Icon(Icons.Outlined.ShoppingCart, contentDescription = null) },
                        onClick = { /* Handle click */ }
                    )

                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                    Text("Section 2", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleMedium)
                    NavigationDrawerItem(
                        label = { Text("Settings") },
                        selected = false,
                        icon = { Icon(Icons.Outlined.Settings, contentDescription = null) },
                        badge = { Text("20") }, // Placeholder
                        onClick = { /* Handle click */ }
                    )
                    NavigationDrawerItem(
                        label = { Text("Help and feedback") },
                        selected = false,
                        icon = { Icon(Icons.Outlined.MailOutline, contentDescription = null) },
                        onClick = { /* Handle click */ },
                    )
                    Spacer(Modifier.height(12.dp))
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {  },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open()
                                } else {
                                    drawerState.close()
                                }
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")

                        }
                    }
                )
            }
        ) {
            when (currentPage) {
                0 -> HomePage()
                1 -> ViewMenuPage(sampleMenu)
            }
        }
    }
}