package com.g2m.deebcallrecorder.models.dataModels

import androidx.room.Entity

@Entity(tableName = "audioTabel")
class AudioModel {
     var name:String=""
    var path:String=""
    var date:String=""

}