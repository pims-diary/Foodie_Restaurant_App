package com.example.foodieapp

import com.example.foodieapp.datalayer.datamodel.FoodItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface FoodApiService {
    @GET("mongo/get-all-food-menu")
    suspend fun getFoodItems(): List<FoodItem>
}

class FoodRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:5000/") // Your base URL
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(FoodApiService::class.java)

    suspend fun getFoodItems() = api.getFoodItems()
}
