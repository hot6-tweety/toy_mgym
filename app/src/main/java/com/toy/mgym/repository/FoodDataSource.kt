package com.toy.mgym.repository

import com.toy.mgym.model.FoodData

interface FoodDataSource {
    fun getFoodData(): FoodData?
}