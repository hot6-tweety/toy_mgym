package com.toy.mgym.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.toy.mgym.model.FoodInfo
import com.toy.mgym.repository.FoodRepository

class SearchViewModel(private val foodRepository: FoodRepository) : ViewModel() {

    private val _foods = MutableLiveData<List<FoodInfo>>()
    val foods: LiveData<List<FoodInfo>> = _foods

    init {
        loadSearch()
    }

    private fun loadSearch() {
        val foodData = foodRepository.getFoodData()
        foodData?.let { foodData ->
            _foods.value = foodData.items
        }
    }

}