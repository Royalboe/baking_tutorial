package com.royalboe.bakingtutorial.recipelist

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.royalboe.bakingtutorial.network.Recipe

@BindingAdapter("listdata")
fun bindRecyclerViewData(recyclerView: RecyclerView, data: List<Recipe>?) {
    val adapter = recyclerView.adapter as RecipeListAdapter
    adapter.submitList(data)
}