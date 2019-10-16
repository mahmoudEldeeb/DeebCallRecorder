package com.g2m.deebcallrecorder.di.app

import android.app.Application
import android.content.Context
import com.g2m.deebcallrecorder.models.local.databse.DataDao
import com.g2m.deebcallrecorder.models.local.databse.LocalDatabse
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
 class AppModule {



    @Singleton
    @Provides
    internal fun provideContext(application: Application): Context {
        return application.applicationContext
    }


    @Singleton
    @Provides
    internal fun provideLocalDatabse(application: Application): LocalDatabse {
            return LocalDatabse.getDatabase(application)

    }

    @Singleton
    @Provides
    internal fun provideDataDao(localDatabse: LocalDatabse): DataDao {
        return localDatabse.getDao()
    }

}