package com.toy.mgym.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.toy.mgym.R
import com.toy.mgym.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    //private val viewModel: SearchViewModel by viewModels { com.toy.mgym.ViewModelFactory(requireContext()) }

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

        val openButton = binding.btnActionToFood
        openButton.setOnClickListener { openSearchFood() }

    }

    private fun openSearchFood() {
        findNavController().navigate(R.id.action_search_to_search_food)
    }
}