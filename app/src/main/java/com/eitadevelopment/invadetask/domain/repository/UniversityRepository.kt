package com.eitadevelopment.invadetask.domain.repository

import com.eitadevelopment.invadetask.core.utils.ResultHandler
import com.eitadevelopment.invadetask.domain.entity.UniversityDetails
import kotlinx.coroutines.flow.Flow

interface UniversityRepository {
    suspend fun getUniversities(): Flow<ResultHandler<List<UniversityDetails>>>
}