package com.eitadevelopment.invadetask.core.di.module

import com.eitadevelopment.invadetask.core.utils.Constants
import com.eitadevelopment.invadetask.data.datasource.remote.UniversityAPI
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun retrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        headerInterceptor: Interceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
        builder.addInterceptor(loggingInterceptor)

        return builder.build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor { message: String ->
            Timber.d(
                message
            )
        }.setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideHeaderInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val timeoutSeconds = 10000
            val request = chain.request()
            val requestBuilder = request.newBuilder()
            requestBuilder
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("Timeout", timeoutSeconds.toString())
            chain.proceed(requestBuilder.build())
        }
    }

    @Singleton
    @Provides
    fun provideUniversityApi(retrofit: Retrofit): UniversityAPI {
        return retrofit.create(UniversityAPI::class.java)
    }
}