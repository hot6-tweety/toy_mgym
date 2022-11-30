package com.toy.mgym.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toy.mgym.model.FoodInfo
import com.toy.mgym.repository.FoodDataRepository
import kotlinx.coroutines.launch

class SearchViewModel(private val foodDataRepository: FoodDataRepository) : ViewModel() {

    private val _foods = MutableLiveData<List<FoodInfo?>?>()
    private val foods: LiveData<List<FoodInfo?>?> = _foods

    init {
        loadSearch()
    }

    private fun loadSearch() {
        viewModelScope.launch {
            val foodData = foodDataRepository.getFoodData()
            _foods.value = foodData.items
        }
    }

}