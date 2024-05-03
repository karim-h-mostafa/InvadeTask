package com.eitadevelopment.invadetask.data.map

import com.eitadevelopment.invadetask.data.datasource.roomdb.entity.UniversityEntity
import com.eitadevelopment.invadetask.domain.entity.UniversityDetails
import com.eitadevelopment.invadetask.domain.map.GenericMapper

class UniversityEntityToUniversityDetailsMapperImp : GenericMapper<UniversityEntity, UniversityDetails> {
    override fun forwardMapping(value: UniversityEntity): UniversityDetails {
        return UniversityDetails(
            domains = value.domains,
            stateProvince = value.stateProvince ?: "No state to show",
            name = value.name,
            webPages = value.webPages,
            country = value.country,
            alphaTwoCode = value.alphaTwoCode
        )
    }

    override fun backwardMapping(value: UniversityDetails): UniversityEntity {
        return UniversityEntity(
            domains = value.domains,
            stateProvince = value.stateProvince,
            name = value.name,
            webPages = value.webPages,
            country = value.country,
            alphaTwoCode = value.alphaTwoCode
        )
    }
}