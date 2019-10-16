package com.g2m.deebcallrecorder.services

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.media.MediaRecorder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import com.g2m.deebcallrecorder.models.dataModels.AudioModel
import com.g2m.deebcallrecorder.models.repositries.SaveAudioRepositry
import dagger.android.DaggerService
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import java.io.File
import java.util.*
import javax.inject.Inject


class RecordSercice : DaggerService() {
    @set:Inject
    lateinit var audioRepositry: SaveAudioRepositry
    object recordeing{
        var isRecorder:Boolean =false
        val mediarecoder=MediaRecorder()
        var mPath:String = ""
        var date:String=""

    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    @SuppressLint("CheckResult")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

           // mFileName = MyFileManager.getFilename(this,mPhoneNumber, mStatusCall);


        if(recordeing.isRecorder){
           stopRecord()
        }
        else {
        startRecord()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun stopRecord() {
        recordeing.mediarecoder.stop()
        var audioModel=AudioModel()
        audioModel.name="Unknowen"
        audioModel.date=recordeing.date
        audioModel.path=recordeing.mPath
        Log.v("dddd","services ")

        audioRepositry.saveAudio(audioModel)

        recordeing.isRecorder=false
        recordeing.mPath=""
        recordeing.date=""
    }

    private fun startRecord() {
        val file = File(getFilePath(), "call recorderss")
        if(!file.isDirectory){
            file.mkdir()
        }
        var d=Date()
        recordeing.date= getDate(d)

        var name: String = d.time.toString()
        recordeing.mediarecoder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL)
        recordeing.mediarecoder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        recordeing.mPath = file.absolutePath + File.separator + name + ".3gp"
        recordeing.mediarecoder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
        recordeing.mediarecoder.setOutputFile(recordeing.mPath)
        recordeing.mediarecoder.prepare()
        Thread.sleep(1000)
        recordeing.mediarecoder.start()
        recordeing.isRecorder=true

    }

    fun getFilePath(): String {
        return this.getExternalFilesDir(null)?.absolutePath.toString()
    }
fun getDate( date: Date):String{
    val sdf = java.text.SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    return sdf.format(date)
}

}
