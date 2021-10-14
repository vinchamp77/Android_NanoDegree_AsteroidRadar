package com.udacity.asteroidradar.api

import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.NetworkConstants
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object AsteroidApi {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(NetworkConstants.BASE_URL)
        .build()

    private val retrofitService : IAsteroidApiService by lazy {
        retrofit.create(IAsteroidApiService::class.java)
    }

    suspend fun getAsteroids(startDate:String, endDate: String, apiKey: String) : List<Asteroid> {
        val responseStr = retrofitService.getAsteroids(startDate, endDate, apiKey)
        val responseJsonObject = JSONObject(responseStr)

        return parseAsteroidsJsonResult(responseJsonObject)
    }
}