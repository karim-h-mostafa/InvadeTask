package com.eitadevelopment.invadetask.core.di.module

import com.eitadevelopment.invadetask.data.datasource.UniversityDataSource
import com.eitadevelopment.invadetask.data.datasource.UniversityDataSourceImpl
import com.eitadevelopment.invadetask.data.datasource.remote.UniversityAPI
import com.eitadevelopment.invadetask.data.datasource.roomdb.dao.UniversityDAO
import com.eitadevelopment.invadetask.data.dto.University
import com.eitadevelopment.invadetask.data.repository.UniversityRepositoryImpl
import com.eitadevelopment.invadetask.domain.entity.UniversityDetails
import com.eitadevelopment.invadetask.domain.map.GenericMapper
import com.eitadevelopment.invadetask.domain.map.MappingProvider
import com.eitadevelopment.invadetask.domain.repository.UniversityRepository
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule {
    @Provides
    fun universityDataSource(
        mapper: MappingProvider,
        universityAPI: UniversityAPI,
        universityDAO: UniversityDAO,
    ): UniversityDataSource {
        return UniversityDataSourceImpl(
            universityClient = universityAPI,
            mapper = mapper,
            dataBaseClient = universityDAO
        )
    }

    @Provides
    fun universityRepository(
        universityDataSource: UniversityDataSource
    ): UniversityRepository {
        return UniversityRepositoryImpl(
            universityDataSource
        )
    }
}