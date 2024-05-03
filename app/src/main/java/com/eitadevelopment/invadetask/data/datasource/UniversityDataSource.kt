package com.eitadevelopment.invadetask.data.datasource

import com.eitadevelopment.invadetask.core.utils.ResultHandler
import com.eitadevelopment.invadetask.domain.entity.UniversityDetails
import kotlinx.coroutines.flow.Flow

interface UniversityDataSource {
    suspend fun getUniversities(): Flow<ResultHandler<List<UniversityDetails>>>
}