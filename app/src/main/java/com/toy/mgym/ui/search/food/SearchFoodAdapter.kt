package com.toy.mgym.ui.search.food

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.toy.mgym.databinding.ItemFoodBinding
import com.toy.mgym.model.FoodInfo

class SearchFoodAdapter(private val viewModel: SearchFoodViewModel) :
    ListAdapter<FoodInfo, SearchFoodAdapter.SearchFoodViewHolder>(FoodDiffCallback()) {

    private lateinit var binding: ItemFoodBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchFoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchFoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchFoodViewHolder, position: Int) {

        holder.bind(getItem(position))
    }

    inner class SearchFoodViewHolder(private val binding: ItemFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(food: FoodInfo) {
            binding.viewModel = viewModel
            binding.food = food
            binding.executePendingBindings()
        }
    }
}

class FoodDiffCallback : DiffUtil.ItemCallback<FoodInfo>() {

    override fun areItemsTheSame(oldItem: FoodInfo, newItem: FoodInfo): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: FoodInfo, newItem: FoodInfo): Boolean {
        return oldItem == newItem
    }
}
