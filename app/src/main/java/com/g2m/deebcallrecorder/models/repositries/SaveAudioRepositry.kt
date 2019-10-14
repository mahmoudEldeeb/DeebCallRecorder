package com.g2m.deebcallrecorder.models.repositries

import android.content.Context
import com.g2m.deebcallrecorder.models.dataModels.AudioModel
import com.g2m.deebcallrecorder.models.local.databse.DataDao
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SaveAudioRepositry  @Inject constructor(dataDao: DataDao) {
var data=dataDao
    fun saveAudio(){

        Completable.fromAction(Action {
            var a=AudioModel()
            a.name="sdsssss"
            data.insertAudio(a)
        }
        ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}