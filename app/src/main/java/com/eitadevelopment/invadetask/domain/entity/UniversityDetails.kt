package com.eitadevelopment.invadetask.domain.entity

data class UniversityDetails(
    val domains: List<String>,
    val stateProvince: String,
    val name: String,
    val webPages: List<String>,
    val country: String,
    val alphaTwoCode: String
)