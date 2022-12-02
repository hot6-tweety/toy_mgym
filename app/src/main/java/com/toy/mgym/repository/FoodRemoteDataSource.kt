package com.toy.mgym.repository

import com.toy.mgym.ApiClient
import com.toy.mgym.model.FoodBody
import com.toy.mgym.model.FoodData

class FoodRemoteDataSource(private val apiClient: ApiClient): FoodDataSource {

    override suspend fun getFoodData(): FoodBody {
        return apiClient.getFoodData()
        // TODO 식품이름 사용자 입력 인자로 요청할 것
    }

}