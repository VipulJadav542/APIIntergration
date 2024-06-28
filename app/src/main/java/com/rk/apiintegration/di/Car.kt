package com.rk.apiintegration.di

import android.util.Log

class Car constructor(private val engine: Engine, private val wheel: Wheel) {
    fun getCar() {
        engine.getEngine()
        wheel.getwheel()
        Log.d("main", "getCar")
    }
}


class Engine {
    fun getEngine() {
        Log.d("main", "getEngine")
    }
}


class Wheel {
    fun getwheel() {
        Log.d("main", "getwheel")
    }
}
