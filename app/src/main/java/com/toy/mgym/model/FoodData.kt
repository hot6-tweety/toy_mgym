package com.toy.mgym.model


import com.google.gson.annotations.SerializedName

data class FoodData(
    @SerializedName("items")
    val items: List<FoodInfo>,
    @SerializedName("numOfRows")
    val numOfRows: Int,
    @SerializedName("pageNo")
    val pageNo: Int,
    @SerializedName("totalCount")
    val totalCount: Int
)

data class FoodInfo(
    @SerializedName("ANIMAL_PLANT")
    val animalPlant: String?,// 가공업체
    @SerializedName("BGN_YEAR")
    val bgnYear: String?,// 구축년도
    @SerializedName("DESC_KOR")
    val name: String?,// 식품이름
    @SerializedName("NUTR_CONT1")
    val calorie: String?,// 열량(kcal)
    @SerializedName("NUTR_CONT2")
    val carbohydrate: String?,// 탄수화물(g)
    @SerializedName("NUTR_CONT3")
    val protein: String?,// 단백질(g)
    @SerializedName("NUTR_CONT4")
    val fat: String?,// 지방(g)
    @SerializedName("NUTR_CONT5")
    val sugars: String?,// 당류(g)
    @SerializedName("NUTR_CONT6")
    val sodium: String?,// 나트륨(mg)
    @SerializedName("NUTR_CONT7")
    val cholesterol: String?,// 콜레스테롤(mg)
    @SerializedName("NUTR_CONT8")
    val saturatedFattyAcids: String?,// 포화지방산(g)
    @SerializedName("NUTR_CONT9")
    val transFattyAcids: String?,// 트랜스지방산(g)
    @SerializedName("SERVING_WT")
    val servingSize: String?// 1회 제공량(g)
)