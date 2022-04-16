package com.royalboe.bakingtutorial.recipelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.royalboe.bakingtutorial.databinding.RecipeListViewBinding
import com.royalboe.bakingtutorial.network.Recipe

class RecipeListAdapter(private val viewModel: RecipeListViewModel): RecyclerView.Adapter<RecipeListAdapter.RecipeListViewHolder>() {

    class RecipeListViewHolder(private val view: RecipeListViewBinding) : RecyclerView.ViewHolder(view.root){
        fun bind(recipe: Recipe) {
            view.recipe = recipe
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListViewHolder {
        return RecipeListViewHolder(RecipeListViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecipeListViewHolder, position: Int) {
        val recipe = viewModel.recipe.value!![position]
        holder.bind(recipe)
    }

    override fun getItemCount() = viewModel.recipe.value!!.size
}