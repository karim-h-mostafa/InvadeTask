package com.eitadevelopment.invadetask.core.di.module

import android.content.Context
import androidx.room.Room
import com.eitadevelopment.invadetask.data.datasource.roomdb.UniversityDB
import com.eitadevelopment.invadetask.data.datasource.roomdb.dao.UniversityDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideCountryDB(context: Context): UniversityDB {
        return Room.databaseBuilder(context, UniversityDB::class.java, "UniversityDB").build()
    }

    @Singleton
    @Provides
    fun provideUniversityDAO(universityDB: UniversityDB): UniversityDAO {
        return universityDB.getUniversityDAO()
    }
}