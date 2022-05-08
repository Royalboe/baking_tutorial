package com.royalboe.bakingtutorial.ingredients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.royalboe.bakingtutorial.RecipeListViewModel
import com.royalboe.bakingtutorial.databinding.FragmentIngredientBinding

class IngredientFragment : Fragment() {
    private var _binding: FragmentIngredientBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: RecipeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIngredientBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        // Inflate the layout for this fragment
        return binding.root
    }
}