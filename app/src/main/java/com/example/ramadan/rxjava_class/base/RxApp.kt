package com.example.ramadan.rxjava_class.base

import android.app.Application

class RxApp :Application() {
    companion object {
        lateinit var  INSTANCE: RxApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }




}