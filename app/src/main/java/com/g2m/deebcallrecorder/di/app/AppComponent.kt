package com.g2m.deebcallrecorder.di.app

import android.app.Application
import com.g2m.deebcallrecorder.di.modules.ActivtYModuleBuilder
import com.g2m.deebcallrecorder.di.modules.ServicesModules
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class,ServicesModules::class, ActivtYModuleBuilder::class])
interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun Build(): AppComponent
    }
}
