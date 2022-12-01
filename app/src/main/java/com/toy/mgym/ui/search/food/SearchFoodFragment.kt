package com.toy.mgym.ui.search.food

import com.toy.mgym.ViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.toy.mgym.databinding.FragmentSearchFoodBinding

class SearchFoodFragment: Fragment() {

    private lateinit var binding: FragmentSearchFoodBinding
    private val viewModel: SearchFoodViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        setFoodList()
    }

    private fun setFoodList() {
        val searchFoodAdapter = SearchFoodAdapter(viewModel)
        binding.rvSearchFood.adapter = searchFoodAdapter
        viewModel.foods.observe(viewLifecycleOwner) {
            searchFoodAdapter.submitList(it)
        }
    }
}