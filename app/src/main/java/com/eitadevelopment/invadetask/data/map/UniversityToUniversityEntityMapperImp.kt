package com.eitadevelopment.invadetask.data.map

import com.eitadevelopment.invadetask.data.datasource.roomdb.entity.UniversityEntity
import com.eitadevelopment.invadetask.data.dto.University
import com.eitadevelopment.invadetask.domain.entity.UniversityDetails
import com.eitadevelopment.invadetask.domain.map.GenericMapper

class UniversityToUniversityEntityMapperImp : GenericMapper<University, UniversityEntity> {
    override fun forwardMapping(value: University): UniversityEntity {
        return UniversityEntity(
            domains = value.domains,
            stateProvince = value.stateProvince ?: "No state to show",
            name = value.name,
            webPages = value.webPages,
            country = value.country,
            alphaTwoCode = value.alphaTwoCode
        )
    }

    override fun backwardMapping(value: UniversityEntity): University {
        return University(
            domains = value.domains,
            stateProvince = value.stateProvince ?: "No state to show",
            name = value.name,
            webPages = value.webPages,
            country = value.country,
            alphaTwoCode = value.alphaTwoCode
        )
    }
}