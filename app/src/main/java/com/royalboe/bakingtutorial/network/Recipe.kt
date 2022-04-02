package com.royalboe.bakingtutorial.network

import com.squareup.moshi.Json

data class Recipe(
    @Json(name = "id") val recipeId: String,
    @Json(name = "name") val recipeName: String,
    val ingredients: Ingredient,
    val steps: Step,
    val servings: String,
    val image: String
)

data class Step(
    @Json(name = "id")val stepId: String,
    val shortDescription: String,
    val description: String,
    @Json(name = "videoURL")val videoUrl: String,
    @Json(name = "thumbnailURL")val thumbNailUrl: String
)

data class Ingredient(
    val quantity: String,
    val measure: String,
    val ingredientName: String
)