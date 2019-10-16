package com.g2m.deebcallrecorder.models.local.databse

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.g2m.deebcallrecorder.models.dataModels.AudioModel
import io.reactivex.Single


@Dao
interface DataDao {

    @Insert
    fun insertAudio(audioModel: AudioModel)

    @Query("select * from AUDIOTABEL")
     fun getAllrecorded(): Single<MutableList<AudioModel>>
}