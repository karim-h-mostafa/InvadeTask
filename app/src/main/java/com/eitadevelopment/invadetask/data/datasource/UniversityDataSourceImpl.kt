package com.eitadevelopment.invadetask.data.datasource

import android.net.http.NetworkException
import com.eitadevelopment.invadetask.core.utils.ResultHandler
import com.eitadevelopment.invadetask.data.datasource.remote.UniversityAPI
import com.eitadevelopment.invadetask.data.datasource.roomdb.dao.UniversityDAO
import com.eitadevelopment.invadetask.domain.entity.UniversityDetails
import com.eitadevelopment.invadetask.domain.map.MappingProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class UniversityDataSourceImpl(
    private val universityClient: UniversityAPI,
    private val dataBaseClient: UniversityDAO,
    private val mapper: MappingProvider

) : UniversityDataSource {
    override suspend fun getUniversities(): Flow<ResultHandler<List<UniversityDetails>>> =
        withContext(Dispatchers.IO) {
            return@withContext flow<ResultHandler<List<UniversityDetails>>> {
                val universitiesList = universityClient.getUniversitiesList()
                universitiesList.body()?.let { universityList ->
                    dataBaseClient.addUniversities(
                        mapper.remoteLocalUniversityMapper.forwardListMapping(
                            universityList
                        )
                    )
                    emit(
                        ResultHandler.Success(
                            mapper.remoteUniversityMapper.forwardListMapping(
                                universityList
                            )
                        )
                    )
                } ?: emit(
                    ResultHandler.Success(
                        mapper.localUniversityMapper.forwardListMapping(dataBaseClient.getLocalUniversities())
                    )
                )
            }.catch { error ->
                dataBaseClient.getLocalUniversities().let { localData ->
                    if (localData.isNotEmpty())
                        emit(
                            ResultHandler.Success(
                                mapper.localUniversityMapper.forwardListMapping(dataBaseClient.getLocalUniversities())
                            )
                        )
                    else
                        emit(ResultHandler.Failure(Exception(error)))
                }

            }
        }
}