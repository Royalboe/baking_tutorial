package com.royalboe.bakingtutorial.recipelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecipeListViewModel: ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    init {
        getRecipes()
    }

    private fun getRecipes() {
        _status.value = "Set API status response"
    }
}