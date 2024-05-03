package com.eitadevelopment.invadetask.data.datasource.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.eitadevelopment.invadetask.data.datasource.roomdb.entity.UniversityEntity

@Dao
interface UniversityDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUniversities(universities: List<UniversityEntity>)

    @Query("SELECT * FROM UniversityEntity")
    suspend fun getLocalUniversities(): List<UniversityEntity>
}