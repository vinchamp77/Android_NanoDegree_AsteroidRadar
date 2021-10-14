package com.udacity.asteroidradar.api

import com.udacity.asteroidradar.Asteroid
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val BASE_URL = "https://api.nasa.gov/"
const val API_KEY = "DEMO_KEY"

object AsteroidApi {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : AsteroidApiServiceI by lazy {
        retrofit.create(AsteroidApiServiceI::class.java)
    }

    suspend fun getAsteroids(apiKey: String) : List<Asteroid> {
        val responseStr = retrofitService.getAsteroids(apiKey)
        val responseJsonObject = JSONObject(responseStr)

        return parseAsteroidsJsonResult(responseJsonObject)
    }
}