package com.udacity.asteroidradar.api

import com.udacity.asteroidradar.NetworkConstants
import com.udacity.asteroidradar.PictureOfDay
import retrofit2.http.GET
import retrofit2.http.Query

interface IAsteroidApiService {

    @GET(NetworkConstants.HTTP_GET_NEO_FEED_PATH)
    suspend fun getAsteroids(
        @Query(NetworkConstants.QUERY_START_DATE_PARAM) startDate: String,
        @Query(NetworkConstants.QUERY_END_DATE_PARAM) endDate: String,
        @Query(NetworkConstants.QUERY_API_KEY_PARAM) apiKey: String): String

    @GET(NetworkConstants.HTTP_GET_APOD_PATH)
    suspend fun getPictureOfDay(@Query(NetworkConstants.QUERY_API_KEY_PARAM) apiKey: String) : PictureOfDay
}