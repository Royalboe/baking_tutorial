package com.royalboe.bakingtutorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.royalboe.bakingtutorial.network.Recipe
import com.royalboe.bakingtutorial.network.RecipeApi
import kotlinx.coroutines.launch

class RecipeListViewModel: ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status
    private val _recipe = MutableLiveData<List<Recipe>>()
    val recipe: LiveData<List<Recipe>> = _recipe

    init {
        getRecipesData()
    }

    private fun getRecipesData() {
        viewModelScope.launch {
            try {
                _recipe.value = RecipeApi.retrofitService.getRecipes()
                _status.value = "Success: The first recipe ingredients are ${_recipe.value!!}"
            } catch (e:Exception) {
                _status.value = "failure ${e.message}"
            }
        }
    }
}