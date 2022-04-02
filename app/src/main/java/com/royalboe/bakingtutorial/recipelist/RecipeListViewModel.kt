package com.royalboe.bakingtutorial.recipelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.royalboe.bakingtutorial.network.RecipeApi
import kotlinx.coroutines.launch

class RecipeListViewModel: ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    init {
        getRecipesData()
    }

    private fun getRecipesData() {
        viewModelScope.launch {
            try {
                val listResult = RecipeApi.retrofitService.getRecipes()
                _status.value = listResult
            } catch (e:Exception) {
                _status.value = "failure ${e.message}"
            }
        }
    }
}