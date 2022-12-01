package com.toy.mgym.repository

import com.google.gson.Gson
import com.toy.mgym.AssetLoader
import com.toy.mgym.model.FoodData

class FoodAssetDatasource(private val assetLoader: AssetLoader) : FoodDataSource {

    private val gson = Gson()

    override fun getFoodData(): FoodData? {
        return assetLoader.getJsonString("food_sample.json")?.let { foodJsonString ->
            gson.fromJson(foodJsonString, FoodData::class.java)
        }
    }
}