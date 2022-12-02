package com.toy.mgym.repository

import com.google.gson.Gson
import com.toy.mgym.AssetLoader
import com.toy.mgym.model.FoodBody
import com.toy.mgym.model.FoodData

class FoodAssetDataSource(private val assetLoader: AssetLoader) : FoodDataSource {

    private val gson = Gson()

    override suspend fun getFoodData(): FoodBody {
        return assetLoader.getJsonString("food_sample.json")?.let { foodJsonString ->
            gson.fromJson(foodJsonString, FoodBody::class.java)
        }!!
    }
}