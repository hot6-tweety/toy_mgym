package com.toy.mgym.repository

import com.toy.mgym.ApiClient
import com.toy.mgym.model.FoodData

class FoodRemoteDataSource(private val apiClient: ApiClient): FoodDataSource {

    override suspend fun getFoodData(): FoodData {
        return apiClient.getFoodData()
    }

}