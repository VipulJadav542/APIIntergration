package com.rk.apiintegration.di

import android.content.Context
import android.util.Log
import android.widget.Toast
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier

class Test @Inject constructor(
    @Fname
    val fname: String,
    @Lname
    val lname: String,

//    @ApplicationContext
    @ActivityContext
    val context: Context
) {
    fun getNames() {
        Log.d("main", "$fname $lname")
        Toast.makeText(context,"hello", Toast.LENGTH_SHORT).show()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object TestModule {
    @Provides
    @Fname
    fun provideFname() = DependancyInjection.fname

    @Provides
    @Lname
    fun provideLname() = DependancyInjection.lname
}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Fname

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Lname
