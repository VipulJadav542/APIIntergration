package com.rk.apiintegration.di

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

interface DemoOne {
    fun demoOne()
}
class DemoOneImplementation @Inject constructor() : DemoOne {
    override fun demoOne() {
        Log.d("main", "demoOneImplementation is calling")
    }
}

class MainOne @Inject constructor(private val demoOne: DemoOne) {
    fun demoOne() {
        demoOne.demoOne()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModul2{

    @Binds
    @Singleton
    abstract fun provideOne(demoOneImplementation: DemoOneImplementation): DemoOne
}
