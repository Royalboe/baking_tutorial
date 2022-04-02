package com.royalboe.bakingtutorial.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://d17h27t6h515a5.cloudfront.net"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface RecipeApiService {
    @GET("topher/2017/May/59121517_baking/baking.json")
    suspend fun getRecipes(): List<Recipe>
}
object RecipeApi {
    val retrofitService: RecipeApiService by lazy {
        retrofit.create(RecipeApiService::class.java)
    }
}
