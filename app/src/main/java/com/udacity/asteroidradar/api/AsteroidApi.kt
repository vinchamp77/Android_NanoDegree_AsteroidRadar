package com.udacity.asteroidradar.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.NetworkConstants
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object AsteroidApi {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(NetworkConstants.BASE_URL)
        .build()

    private val retrofitService : IAsteroidApiService by lazy {
        retrofit.create(IAsteroidApiService::class.java)
    }

suspend fun getAsteroids() : List<Asteroid> {
    val responseStr = retrofitService.getAsteroids("","", NetworkConstants.API_KEY)
    val responseJsonObject = JSONObject(responseStr)

    return parseAsteroidsJsonResult(responseJsonObject)
}

    suspend fun getPictureOfDay() = retrofitService.getPictureOfDay(NetworkConstants.API_KEY)
}