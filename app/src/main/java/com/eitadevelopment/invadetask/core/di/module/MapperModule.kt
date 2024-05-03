package com.eitadevelopment.invadetask.core.di.module

import com.eitadevelopment.invadetask.data.datasource.roomdb.entity.UniversityEntity
import com.eitadevelopment.invadetask.data.dto.University
import com.eitadevelopment.invadetask.data.map.MappingProviderImpl
import com.eitadevelopment.invadetask.data.map.UniversityEntityToUniversityDetailsMapperImp
import com.eitadevelopment.invadetask.data.map.UniversityToUniversityDetailsMapperImp
import com.eitadevelopment.invadetask.data.map.UniversityToUniversityEntityMapperImp
import com.eitadevelopment.invadetask.domain.entity.UniversityDetails
import com.eitadevelopment.invadetask.domain.map.GenericMapper
import com.eitadevelopment.invadetask.domain.map.MappingProvider
import dagger.Module
import dagger.Provides

@Module
class MapperModule {
    @Provides
    fun universityToUniversityDetailsMapper(): GenericMapper<University, UniversityDetails> {
        return UniversityToUniversityDetailsMapperImp()
    }
    @Provides
    fun universityToUniversityEntityMapper(): GenericMapper<University, UniversityEntity> {
        return UniversityToUniversityEntityMapperImp()
    }



    @Provides
    fun universityEntityToUniversityDetailsMapper(): GenericMapper<UniversityEntity, UniversityDetails> {
        return UniversityEntityToUniversityDetailsMapperImp()
    }



    @Provides
    fun mappingProvider(
        localUniversity: GenericMapper<UniversityEntity, UniversityDetails>,
        remoteUniversity: GenericMapper<University, UniversityDetails>,
        remoteLocalUniversity: GenericMapper<University, UniversityEntity>,
    ): MappingProvider {
        return MappingProviderImpl(
            remoteUniversity,
            localUniversity,
            remoteLocalUniversity
        )
    }

}