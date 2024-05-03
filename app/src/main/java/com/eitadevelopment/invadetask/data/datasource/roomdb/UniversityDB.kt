package com.eitadevelopment.invadetask.data.datasource.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.eitadevelopment.invadetask.data.datasource.roomdb.converter.StringListConverter
import com.eitadevelopment.invadetask.data.datasource.roomdb.dao.UniversityDAO
import com.eitadevelopment.invadetask.data.datasource.roomdb.entity.UniversityEntity
@Database(
    entities = [
        UniversityEntity::class
    ], version = 1, exportSchema = false
)
@TypeConverters(StringListConverter::class)
abstract class UniversityDB : RoomDatabase() {
    abstract fun getUniversityDAO(): UniversityDAO
}