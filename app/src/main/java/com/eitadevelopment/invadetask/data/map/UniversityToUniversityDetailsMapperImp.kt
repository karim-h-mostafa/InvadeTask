package com.eitadevelopment.invadetask.data.map

import com.eitadevelopment.invadetask.data.dto.University
import com.eitadevelopment.invadetask.domain.entity.UniversityDetails
import com.eitadevelopment.invadetask.domain.map.GenericMapper

class UniversityToUniversityDetailsMapperImp : GenericMapper<University, UniversityDetails> {
    override fun forwardMapping(value: University): UniversityDetails {
        return UniversityDetails(
            domains = value.domains,
            stateProvince = value.stateProvince ?: "No state to show",
            name = value.name,
            webPages = value.webPages,
            country = value.country,
            alphaTwoCode = value.alphaTwoCode
        )
    }

    override fun backwardMapping(value: UniversityDetails): University {
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