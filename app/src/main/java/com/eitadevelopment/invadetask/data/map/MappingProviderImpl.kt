package com.eitadevelopment.invadetask.data.map

import com.eitadevelopment.invadetask.data.datasource.roomdb.entity.UniversityEntity
import com.eitadevelopment.invadetask.data.dto.University
import com.eitadevelopment.invadetask.domain.entity.UniversityDetails
import com.eitadevelopment.invadetask.domain.map.GenericMapper
import com.eitadevelopment.invadetask.domain.map.MappingProvider

class MappingProviderImpl(
    override val remoteUniversityMapper: GenericMapper<University, UniversityDetails>,
    override val localUniversityMapper: GenericMapper<UniversityEntity, UniversityDetails>,
    override val remoteLocalUniversityMapper: GenericMapper<University, UniversityEntity>
) :MappingProvider {
}