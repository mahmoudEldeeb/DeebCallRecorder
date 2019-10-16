package com.g2m.deebcallrecorder.models.local.databse

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.g2m.deebcallrecorder.models.dataModels.AudioModel
import com.g2m.deebcallrecorder.models.repositries.SaveAudioRepositry
import com.g2m.deebcallrecorder.utils.Constants
import com.g2m.deebcallrecorder.utils.Constants.context
import dagger.internal.DaggerCollections
import javax.inject.Inject
import javax.inject.Singleton


@Database(entities = arrayOf(AudioModel::class), version = 1)
public abstract class LocalDatabse    : RoomDatabase() {

    @Inject
    @Singleton
    lateinit var context: Context

    abstract fun getDao(): DataDao


    // Singleton prevents multiple instances of database opening at the
    // same time.
    companion object {
        @Volatile
        private var INSTANCE: LocalDatabse? = null

        fun getDatabase(application: Application): LocalDatabse {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    application.applicationContext,
                    LocalDatabse::class.java,
                    Constants.DATABASE_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }

}
