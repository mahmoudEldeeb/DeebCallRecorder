package com.g2m.deebcallrecorder.di.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication



class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).Build()
    }

    override fun onCreate() {
        super.onCreate()

    }
}