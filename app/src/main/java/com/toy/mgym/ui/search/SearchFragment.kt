package com.toy.mgym.ui.search

import ViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.toy.mgym.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchFoodAdapter = SearchFoodAdapter()
        binding.rvSearchFood.adapter = searchFoodAdapter
        viewModel.foods.observe(viewLifecycleOwner) {
            searchFoodAdapter.submitList(it)
        }


    }
}