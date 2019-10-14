package com.g2m.deebcallrecorder.models.local.databse

import androidx.room.Room
import com.g2m.deebcallrecorder.utils.Constants

abstract class  LocalDatabse {
    abstract fun dao(): DataDao
    @Volatile
    private var INSTANCE: LocalDatabse? = null

    fun getDatabase(): LocalDatabse? {
        if (INSTANCE == null) {
            synchronized(LocalDatabse::class.java) {
                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(
//                        Constants.context?.getApplicationContext(),
//                        LocalDatabse::class.java!!, Constants.DATABASE_NAME
//                    )
//                        .build()
                }
            }
        }
        return INSTANCE
    }

}