package com.g2m.deebcallrecorder.viewModels

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.g2m.deebcallrecorder.models.dataModels.AudioModel
import com.g2m.deebcallrecorder.models.local.databse.DataDao
import com.g2m.deebcallrecorder.models.repositries.SaveAudioRepositry
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class InboxCallViewModel @Inject constructor(repositry: SaveAudioRepositry): ViewModel() {

     var audioRepositry=repositry
    var inboxCalls:MutableLiveData<MutableList<AudioModel>> = MutableLiveData()
    @SuppressLint("CheckResult")
    fun getAllinboxCalls():MutableLiveData<MutableList<AudioModel>>{

        audioRepositry.getAllrecoreded().subscribeWith(object : SingleObserver<MutableList<AudioModel>> {
            override fun onSubscribe(d: Disposable) {
                Log.v("mmm","fghjkl;")

            }

            override fun onError(e: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onSuccess(t: MutableList<AudioModel>) {
                Log.v("mmmm",t.size.toString())
                    inboxCalls.value=t
            }

        })

        return inboxCalls
    }

}