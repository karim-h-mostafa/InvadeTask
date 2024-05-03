package com.eitadevelopment.invadetask.data.datasource.remote

import com.eitadevelopment.invadetask.data.dto.University
import retrofit2.Response
import retrofit2.http.GET

interface UniversityAPI {
    @GET("search?country=United%20Arab%20Emirates")
    suspend fun getUniversitiesList():Response<List<University>>
}