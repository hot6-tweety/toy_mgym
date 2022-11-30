package com.toy.mgym.repository

import com.toy.mgym.ApiClient
import com.toy.mgym.model.FoodData

class FoodRemoteDataSource(private val api: ApiClient): FoodDataSource {
    override suspend fun getFoodData(): FoodData {
        return api.getFoodData()
    }
}