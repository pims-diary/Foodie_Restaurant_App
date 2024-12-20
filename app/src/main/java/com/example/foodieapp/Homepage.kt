package com.example.foodieapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun Homepage() {
    LazyColumn(modifier = Modifier.padding(top = 90.dp)) {
        item {
            // First image
            Image(
                painter = painterResource(id = R.drawable.biryani),
                contentDescription = stringResource(id = R.string.biryani),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(bottom = 16.dp) // Add spacing below
            )
        }
        item {
            // Second image
            Image(
                painter = painterResource(id = R.drawable.food1),
                contentDescription = stringResource(id = R.string.food1),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(bottom = 16.dp) // Add spacing below
            )
        }
        item {
            // Third image
            Image(
                painter = painterResource(id = R.drawable.food2),
                contentDescription = stringResource(id = R.string.food2),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(bottom = 16.dp) // Add spacing below
            )
        }
        item {
            // Fourth image
            Image(
                painter = painterResource(id = R.drawable.food4),
                contentDescription = stringResource(id = R.string.food4),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(bottom = 16.dp) // Add spacing below
            )
        }
        item {
            // Fifth image
            Image(
                painter = painterResource(id = R.drawable.food5),
                contentDescription = stringResource(id = R.string.food5),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(bottom = 16.dp) // Add spacing below
            )
        }
    }
}
