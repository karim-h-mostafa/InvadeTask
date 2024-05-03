package com.eitadevelopment.invadetask.core.di.module

import com.eitadevelopment.invadetask.domain.repository.UniversityRepository
import com.eitadevelopment.invadetask.domain.usecase.GetUniversitiesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun getUniversitiesUseCase(
        universityRepository: UniversityRepository
    ): GetUniversitiesUseCase {
        return GetUniversitiesUseCase(universityRepository)
    }
}