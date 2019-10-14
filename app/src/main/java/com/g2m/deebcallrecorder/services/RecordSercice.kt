package com.g2m.deebcallrecorder.services

import android.app.Service
import android.content.Intent
import android.icu.text.DateFormat
import android.media.MediaRecorder
import android.os.Environment
import android.os.IBinder
import android.os.Environment.getExternalStorageDirectory
import android.provider.MediaStore
import java.io.File
import java.util.*


class RecordSercice : Service() {

    object recordeing{
        var isRecorder:Boolean =false
        val mediarecoder=MediaRecorder()
        var mPath:String = ""

    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

           // mFileName = MyFileManager.getFilename(this,mPhoneNumber, mStatusCall);
        if(recordeing.isRecorder){
            recordeing.mediarecoder.stop()
            recordeing.isRecorder=false
            recordeing.mPath=""
        }
        else {
            val file = File(getFilePath(), "call recorderss")
            if(!file.isDirectory){
                file.mkdir()
            }

            var d = Date()
            var myDate = d.time
            var name: String = myDate.toString();
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
        return super.onStartCommand(intent, flags, startId)
    }
    fun getFilePath(): String {
        // TODO: Change to user selected directory
        return this.getExternalFilesDir(null)?.absolutePath.toString()
    }

}
