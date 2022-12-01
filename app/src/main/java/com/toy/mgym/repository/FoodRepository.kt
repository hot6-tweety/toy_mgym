package com.toy.mgym.repository

import com.toy.mgym.model.FoodData

class FoodRepository(private val assetDataSource: FoodAssetDatasource) {

    fun getFoodData(): FoodData? {
        return assetDataSource.getFoodData()
    }
}