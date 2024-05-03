package com.eitadevelopment.invadetask.domain.usecase

import com.eitadevelopment.invadetask.domain.repository.UniversityRepository

class GetUniversitiesUseCase(
    private val universityRepository: UniversityRepository
) {
    suspend operator fun invoke() = universityRepository.getUniversities()
}