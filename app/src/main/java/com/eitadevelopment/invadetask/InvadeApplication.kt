package com.eitadevelopment.invadetask

import android.app.Application
import android.content.Context
import com.eitadevelopment.invadetask.core.di.ApplicationComponent
import com.eitadevelopment.invadetask.core.di.DaggerApplicationComponent
import com.google.android.play.core.splitcompat.SplitCompat

class InvadeApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}