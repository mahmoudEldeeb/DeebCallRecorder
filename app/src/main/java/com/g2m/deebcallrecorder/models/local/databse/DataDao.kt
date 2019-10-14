package com.g2m.deebcallrecorder.models.local.databse

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.g2m.deebcallrecorder.models.dataModels.AudioModel


@Dao
interface DataDao {

    @Insert
   abstract fun insertAudio(audioModel: AudioModel)

}