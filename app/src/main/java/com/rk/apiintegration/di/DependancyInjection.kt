package com.rk.apiintegration.di

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rk.apiintegration.BaseApp
import com.rk.apiintegration.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class DependancyInjection : AppCompatActivity() {
//    private val baseApp: BaseApp
//        get() = BaseApp()

    //field injection
    @Inject
    lateinit var computer: Computer

    @Inject
    lateinit var mainOne: MainOne

    @Inject
    lateinit var mainTwo: MainTwo

    @Inject
    lateinit var test: Test
//    private val download=DownloaderFactory.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dependancy_injection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    computer.getComputer()

//        baseApp.car.getCar()
//        download.getDownload()

    mainOne.demoOne()
    mainTwo.mainTwo()
    test.getNames()
    }

    companion object
    {
        val fname="vipul"
        val lname="jadav"
    }
}