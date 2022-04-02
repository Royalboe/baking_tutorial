package com.royalboe.bakingtutorial.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://d17h27t6h515a5.cloudfront.net"

val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface RecipeApiService {
    @GET("topher/2017/May/59121517_baking/baking.json")
    suspend fun getRecipes(): String
}
object RecipeApi {
    val retrofitService: RecipeApiService by lazy {
        retrofit.create(RecipeApiService::class.java)
    }
}
