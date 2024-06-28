package com.rk.apiintegration

import android.app.Application
import com.rk.apiintegration.di.Appmodule1
import com.rk.apiintegration.di.Car
import com.rk.apiintegration.di.Engine
import com.rk.apiintegration.di.Wheel
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
//val computer=Computer()

class BaseApp:Application() {
    val car=Car(Engine(), Wheel())
    val main= Appmodule1.main
}