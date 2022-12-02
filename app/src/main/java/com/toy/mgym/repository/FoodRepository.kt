package com.toy.mgym.repository

import com.toy.mgym.model.FoodBody
import com.toy.mgym.model.FoodData

class FoodRepository(private val remoteDatasource: FoodRemoteDataSource) {

    suspend fun getFoodData(): FoodBody {
        return remoteDatasource.getFoodData()
        // TODO totalCount 가 0이면 '검색결과없음' 안내 문구 필요하므로 그에 따른 처리
    }
}