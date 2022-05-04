package com.royalboe.bakingtutorial.ingredients

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.royalboe.bakingtutorial.databinding.IngredientsViewBinding
import com.royalboe.bakingtutorial.network.Ingredient

class IngredientsAdapter: ListAdapter<Ingredient, IngredientsAdapter.IngredientViewHolder>(
    DiffUtilCallback
) {
    class IngredientViewHolder(private val binding: IngredientsViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredient: Ingredient) {
            binding.ingredient = ingredient
        }
    }

    companion object DiffUtilCallback: DiffUtil.ItemCallback<Ingredient>() {
        override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
            return oldItem.ingredientName == oldItem.ingredientName
        }

        override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
           return oldItem.quantity == oldItem.quantity
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IngredientsAdapter.IngredientViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: IngredientsAdapter.IngredientViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}