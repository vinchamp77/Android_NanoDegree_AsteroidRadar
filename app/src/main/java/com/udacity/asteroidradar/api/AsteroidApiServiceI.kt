package com.udacity.asteroidradar.api

import retrofit2.http.GET
import retrofit2.http.Query

interface AsteroidApiServiceI {

    @GET("neo/rest/v1/feed")
    suspend fun getAsteroids(@Query("api_key") type: String): String

}