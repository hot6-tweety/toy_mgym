package com.toy.mgym.repository

import com.toy.mgym.model.FoodData

class FoodRepository(private val remoteDatasource: FoodRemoteDataSource) {

    suspend fun getFoodData(): FoodData {
        return remoteDatasource.getFoodData()
    }
}