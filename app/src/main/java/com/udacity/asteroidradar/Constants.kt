package com.udacity.asteroidradar

object NetworkConstants {
    const val API_KEY = "DEMO_KEY"

    const val BASE_URL = "https://api.nasa.gov/"
    const val HTTP_GET_PATH = "neo/rest/v1/feed"
    const val QUERY_START_DATE_PARAM = "start_date"
    const val QUERY_END_DATE_PARAM = "end_date"
    const val QUERY_API_KEY_PARAM = "api_key"

    const val API_QUERY_DATE_FORMAT = "yyyy-MM-dd" // change YYYY to yyyy as it doesn't compatible with API 21
    const val DEFAULT_END_DATE_DAYS = 7
}

object DatabaseConstants {
    const val TABLE_NAME = "asteroid"
    const val DATABASE_FILE_NAME = "asteroid.db"
}