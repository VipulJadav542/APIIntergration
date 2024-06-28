package com.rk.apiintegration.di

import android.util.Log

interface One{
    fun one()
}

class ImplementationOne:One{
    override fun one() {
        Log.d("main","one is running")
    }
}

class Main constructor(private val one: One)
{
    fun main() {
        one.one()
    }
}


object Appmodule1{
    val main=Main(ImplementationOne())
}