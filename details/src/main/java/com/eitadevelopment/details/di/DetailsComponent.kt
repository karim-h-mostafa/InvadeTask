package com.eitadevelopment.details.di

import com.eitadevelopment.details.DetailsScreenFragment
import com.eitadevelopment.invadetask.core.di.ApplicationComponent
import com.eitadevelopment.invadetask.core.di.scope.ListingModule

import dagger.Component

@ListingModule
@Component(
    dependencies = [
        ApplicationComponent::class
    ]
)
interface DetailsComponent {
    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent): DetailsComponent
    }

    fun inject(detailsScreenFragment: DetailsScreenFragment )
}