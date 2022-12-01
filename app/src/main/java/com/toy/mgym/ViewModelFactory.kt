package com.toy.mgym

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.toy.mgym.repository.FoodRemoteDataSource
import com.toy.mgym.repository.FoodRepository
import com.toy.mgym.ui.search.food.SearchFoodViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SearchFoodViewModel::class.java) -> {
                val repository = FoodRepository(FoodRemoteDataSource(ApiClient.create()))
                SearchFoodViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to crete ViewModel: ${modelClass.name}")
            }
        }
    }
}