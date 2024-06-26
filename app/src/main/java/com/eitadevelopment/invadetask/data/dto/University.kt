package com.eitadevelopment.invadetask.data.dto

import com.google.gson.annotations.SerializedName

data class University(
    @SerializedName("domains")
    val domains: List<String>,
    @SerializedName("state-province")
    val stateProvince: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("web_pages")
    val webPages: List<String>,
    @SerializedName("country")
    val country: String,
    @SerializedName("alpha_two_code")
    val alphaTwoCode: String
)