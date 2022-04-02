package com.royalboe.bakingtutorial.network

data class Recipe(
    val recipeId: Int,
    val recipeName: String,
    val ingredients: Ingredient,
    val steps: Steps,
    val servings: Int,
    val image: String
)

data class Steps(
    val stepId: Int,
    val shortDescription: String,
    val description: String,
    val videoUrl: String,
    val thumbNailUrl: String
)

data class Ingredient(
    val quantity: String,
    val measure: String,
    val ingredientName: String
)