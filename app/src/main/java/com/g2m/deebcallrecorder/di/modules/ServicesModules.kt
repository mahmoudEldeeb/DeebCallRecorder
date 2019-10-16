package com.g2m.deebcallrecorder.di.modules

import com.g2m.deebcallrecorder.services.RecordSercice
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServicesModules {
    @ContributesAndroidInjector
     abstract fun contributeRecordSercice(): RecordSercice
}