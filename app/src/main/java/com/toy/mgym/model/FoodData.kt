package com.toy.mgym.model


import com.squareup.moshi.Json

data class FoodData(
    @field:Json(name = "items")
    val items: List<FoodInfo?>?,
    @field:Json(name = "numOfRows")
    val numOfRows: Int?,
    @field:Json(name = "pageNo")
    val pageNo: Int?,
    @field:Json(name = "totalCount")
    val totalCount: Int?
)

data class FoodInfo(
    @field:Json(name = "ANIMAL_PLANT")
    val animalPlant: String?,// 가공업체
    @field:Json(name = "BGN_YEAR")
    val bgnYear: String?,// 구축년도
    @field:Json(name = "DESC_KOR")
    val name: String?,// 식품이름
    @field:Json(name = "NUTR_CONT1")
    val calorie: String?,// 열량(kcal)
    @field:Json(name = "NUTR_CONT2")
    val carbohydrate: String?,// 탄수화물(g)
    @field:Json(name = "NUTR_CONT3")
    val protein: String?,// 단백질(g)
    @field:Json(name = "NUTR_CONT4")
    val fat: String?,// 지방(g)
    @field:Json(name = "NUTR_CONT5")
    val sugars: String?,// 당류(g)
    @field:Json(name = "NUTR_CONT6")
    val sodium: String?,// 나트륨(mg)
    @field:Json(name = "NUTR_CONT7")
    val cholesterol: String?,// 콜레스테롤(mg)
    @field:Json(name = "NUTR_CONT8")
    val saturatedFattyAcids: String?,// 포화지방산(g)
    @field:Json(name = "NUTR_CONT9")
    val transFattyAcids: String?,// 트랜스지방산(g)
    @field:Json(name = "SERVING_WT")
    val servingSize: String?// 1회 제공량(g)
)