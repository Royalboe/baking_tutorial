package com.royalboe.bakingtutorial.recipelist

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecipeListAdapter(private val viewModel: RecipeListViewModel): RecyclerView.Adapter<RecipeListAdapter.RecipeListViewHolder>() {

    class RecipeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecipeListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = viewModel.recipe.value!!.size
}