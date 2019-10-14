package com.g2m.deebcallrecorder.models.local.databse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.g2m.deebcallrecorder.models.dataModels.AudioModel
import com.g2m.deebcallrecorder.utils.Constants
import com.g2m.deebcallrecorder.utils.Constants.context
import javax.inject.Inject



@Database(entities = arrayOf(AudioModel::class), version = 1)
public abstract class LocalDatabse @Inject constructor(ctx: Context)  : RoomDatabase()  {
    var context=ctx;

    abstract fun getDao(): DataDao


        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: LocalDatabse? = null

        fun getDatabase(): LocalDatabse {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocalDatabse::class.java,
                    Constants.DATABASE_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }

}


