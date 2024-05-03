package com.eitadevelopment.invadetask.domain.map

import com.eitadevelopment.invadetask.data.datasource.roomdb.entity.UniversityEntity
import com.eitadevelopment.invadetask.data.dto.University
import com.eitadevelopment.invadetask.domain.entity.UniversityDetails

interface MappingProvider {
    val remoteUniversityMapper:GenericMapper<University,UniversityDetails>
    val localUniversityMapper:GenericMapper<UniversityEntity,UniversityDetails>
    val remoteLocalUniversityMapper:GenericMapper<University,UniversityEntity>

}