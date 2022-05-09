package com.royalboe.bakingtutorial.ingredients

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.royalboe.bakingtutorial.databinding.IngredientsViewBinding
import com.royalboe.bakingtutorial.network.Ingredient
import com.royalboe.bakingtutorial.network.Recipe

class IngredientsAdapter(val recipe: Recipe): RecyclerView.Adapter<IngredientsAdapter.IngredientViewHolder>() {
    private val dataset = recipe.ingredients
    class IngredientViewHolder(private val binding: IngredientsViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredient: Ingredient) {
            binding.ingredient = ingredient
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IngredientsAdapter.IngredientViewHolder {
        return IngredientViewHolder(IngredientsViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: IngredientsAdapter.IngredientViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataset.size
}