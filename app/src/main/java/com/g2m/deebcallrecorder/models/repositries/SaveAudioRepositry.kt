package com.g2m.deebcallrecorder.models.repositries

import android.annotation.SuppressLint
import android.util.Log
import com.g2m.deebcallrecorder.models.dataModels.AudioModel
import com.g2m.deebcallrecorder.models.local.databse.DataDao
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

import io.reactivex.functions.Action
import io.reactivex.plugins.RxJavaPlugins.onError
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SaveAudioRepositry  @Inject constructor(dataDao: DataDao) {
var data=dataDao


    fun insertRecord(audioModel: AudioModel) =
        Completable.create {
            Log.v("dddd","nnnnnnnnnnn")

            data.insertAudio(audioModel)
            Log.v("dddd","weee")

            it.onComplete()
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())


    @SuppressLint("CheckResult")
    fun saveAudio(audioModel: AudioModel) {
        Log.v("dddd","ddddd")


       var c:Completable
        c=Completable.fromAction(Action
        {
                data.insertAudio(audioModel)

        }
        ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        c.subscribeWith(
            object :CompletableObserver{
                override fun onComplete() {
                    Log.v("dddd", "succes")

                }

                override fun onSubscribe(d: Disposable) {

                }
                override fun onError(e: Throwable) {
                    Log.v("dddd", e.message)

                }

            }
        )







    }



    fun getAllrecoreded():Single<MutableList<AudioModel>>
    {
        return data.getAllrecorded().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    }
}