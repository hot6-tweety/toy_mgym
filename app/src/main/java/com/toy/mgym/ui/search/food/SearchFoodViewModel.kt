package com.toy.mgym.ui.search.food

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toy.mgym.model.FoodInfo
import com.toy.mgym.repository.FoodRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchFoodViewModel(
    private val foodRepository: FoodRepository
): ViewModel() {

    private val _foods = MutableLiveData<List<FoodInfo>>()
    val foods: LiveData<List<FoodInfo>> = _foods

    init {
        loadFood()
    }

    private fun loadFood(){
        viewModelScope.launch {
            val foods = foodRepository.getFoodData().foodData.items
            _foods.value = foods
        }
    }
}