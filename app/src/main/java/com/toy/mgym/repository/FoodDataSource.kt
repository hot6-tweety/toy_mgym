package com.toy.mgym.repository

import com.toy.mgym.model.FoodData

interface FoodDataSource {
    suspend fun getFoodData(): FoodData
}
