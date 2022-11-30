package com.toy.mgym.repository

import com.toy.mgym.model.FoodData

class FoodDataRepository(private val remoteDataSource: FoodRemoteDataSource) {
    suspend fun getFoodData(): FoodData{
        return remoteDataSource.getFoodData()
    }
}