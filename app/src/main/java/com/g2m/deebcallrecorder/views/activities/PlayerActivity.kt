package com.g2m.deebcallrecorder.views.activities

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.g2m.deebcallrecorder.models.dataModels.AudioModel
import kotlinx.android.synthetic.main.activity_player.*
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit
import android.R.attr.path
import com.g2m.deebcallrecorder.R


class PlayerActivity : AppCompatActivity() {
object Global{
    var audioModel: AudioModel? = null
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        Global.audioModel= intent.getSerializableExtra("record") as AudioModel?
        player_img_play.setOnClickListener {
            Log.v("aaaa",  ".........")
            play()
        }

    }

     fun play() {
         Log.v("aaaa", Uri.fromFile(File(Global.audioModel?.path)).toString())

//        val mMediaPlayer = MediaPlayer.create(this,
//            Uri.fromFile(File(Global.audioModel?.path))
//        ) ?: return
//        Log.v("aaaa",            Uri.fromFile(File(Global.audioModel?.path)).toString())
//        //		mSeekbar.setMax((int) mMediaPlayer.getDuration());
//
//        mMediaPlayer.prepare()
//        mMediaPlayer.start()
//        Log.v("aaaa",  ".........")
         val mp :MediaPlayer= MediaPlayer()
         mp.setDataSource( Global.audioModel?.path)

         try {
             Log.v("aaaa",  "11111111111111")
        if(mp==null){

             Log.v("aaaa",  "222222222")}

             mp.prepare()
             Log.v("aaaa",  "333333333333")

             mp.start()
         } catch (e: Exception) {
             Log.v("aaaa",  e.toString())

             e.printStackTrace()
         }


     }
}
