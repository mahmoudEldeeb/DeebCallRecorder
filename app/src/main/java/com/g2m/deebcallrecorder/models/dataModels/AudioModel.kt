package com.g2m.deebcallrecorder.models.dataModels

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "audioTabel")
class AudioModel:Serializable {

    @PrimaryKey(autoGenerate = true)
    var id: Int=0

    var name:String=""
    var path:String=""
    var date:String=""

}