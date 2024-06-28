package com.rk.apiintegration.di

import android.util.Log
import javax.inject.Inject

class Computer @Inject constructor(private val ram: Ram,private val hardDisk: HardDisk) {
    fun getComputer() {
        //means computer=Computer()
        ram.getRam()
        hardDisk.getHardDisk()
        Log.d("main", "getComputer")
    }
}

class Ram @Inject constructor() {
    fun getRam() {
        //means computer=Computer()
        Log.d("main", "getRam")
    }
}

class HardDisk @Inject constructor() {
    fun getHardDisk() {
        //means computer=Computer()
        Log.d("main", "getHardDisk")
    }
}