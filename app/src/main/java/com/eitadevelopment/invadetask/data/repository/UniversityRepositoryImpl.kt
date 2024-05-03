package com.eitadevelopment.invadetask.data.repository

import com.eitadevelopment.invadetask.data.datasource.UniversityDataSource
import com.eitadevelopment.invadetask.domain.repository.UniversityRepository

class UniversityRepositoryImpl(
    private val universityDataSource: UniversityDataSource
) : UniversityRepository {
    override suspend fun getUniversities() = universityDataSource.getUniversities()
}