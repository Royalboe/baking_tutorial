package com.royalboe.bakingtutorial.recipelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.royalboe.bakingtutorial.databinding.RecipeListViewBinding
import com.royalboe.bakingtutorial.network.Recipe

class RecipeListAdapter(private val viewModel: RecipeListViewModel, private val dataset: List<Recipe>): RecyclerView.Adapter<RecipeListAdapter.RecipeListViewHolder>() {

    class RecipeListViewHolder(private val view: RecipeListViewBinding) : RecyclerView.ViewHolder(view.root){
        fun bind(recipe: Recipe) {
            view.recipe = recipe
            view.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListViewHolder {
        return RecipeListViewHolder(RecipeListViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecipeListViewHolder, position: Int) {
        val recipe = viewModel.recipe.value?.get(position)
        if (recipe != null) {
            holder.bind(recipe)
        }
    }

    companion object DiffCallBack: DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.recipeId == newItem.recipeId
        }

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.recipeName == newItem.recipeName
        }
    }

    override fun getItemCount() = dataset.size
}