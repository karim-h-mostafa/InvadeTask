package com.eitadevelopment.listing.di

import com.eitadevelopment.invadetask.core.di.ApplicationComponent
import com.eitadevelopment.invadetask.core.di.scope.ListingModule
import com.eitadevelopment.listing.ListingScreenFragment
import dagger.Component

@ListingModule
@Component(
    dependencies = [
        ApplicationComponent::class
    ]
)
interface ListingComponent {
    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent): ListingComponent
    }

    fun inject(listingScreenFragment: ListingScreenFragment)
}