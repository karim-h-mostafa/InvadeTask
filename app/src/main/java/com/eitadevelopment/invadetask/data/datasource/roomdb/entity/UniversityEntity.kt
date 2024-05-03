package com.eitadevelopment.invadetask.data.datasource.roomdb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.eitadevelopment.invadetask.data.datasource.roomdb.converter.StringListConverter
import com.google.gson.annotations.SerializedName
@TypeConverters(StringListConverter::class)
@Entity
data class UniversityEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long=0,
    @SerializedName("domains")
    val domains: List<String>,
    @SerializedName("state_province")
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