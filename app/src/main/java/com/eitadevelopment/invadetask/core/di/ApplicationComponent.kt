package com.eitadevelopment.invadetask.core.di

import android.content.Context
import com.eitadevelopment.invadetask.core.di.module.AppModule
import com.eitadevelopment.invadetask.core.di.module.DatabaseModule
import com.eitadevelopment.invadetask.core.di.module.MapperModule
import com.eitadevelopment.invadetask.core.di.module.NetworkModule
import com.eitadevelopment.invadetask.core.di.module.RepositoryModule
import com.eitadevelopment.invadetask.core.di.module.UseCaseModule
import com.eitadevelopment.invadetask.ui.NavigationHolderActivity
import com.eitadevelopment.invadetask.ui.SharedViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        MapperModule::class
    ]
)
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(navigationHolderActivity: NavigationHolderActivity)
    fun sharedViewModel(): SharedViewModel
}