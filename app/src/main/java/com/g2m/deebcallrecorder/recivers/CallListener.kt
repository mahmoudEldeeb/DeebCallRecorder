package com.g2m.deebcallrecorder.recivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log
import com.g2m.deebcallrecorder.services.RecordSercice
import com.g2m.deebcallrecorder.utils.Constants
import java.util.*

open class CallListener : BroadcastReceiver() {
     object static {
         var lastState=TelephonyManager.CALL_STATE_IDLE
    }
    private var callStartTime: Date? = null
    private var isIncoming: Boolean = false
    private var savedNumber: String? = null


    private val TAG: String? = "aaaaaa"

    override fun onReceive(context: Context, intent: Intent) {
        Log.v(TAG, "onCallStateChanged : " + "bbbbbbbbbbbbbbbbbbb")

        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if(intent.action.equals("android.intent.action.NEW_OUTGOING_CALL")){
            Log.v(TAG, "onCallStateChanged : " + "bbooooooooooooo")

            savedNumber= intent.extras?.getString("android.intent.extra.PHONE_NUMBER").toString()
        }
        else{
            Log.v(TAG, "onCallStateChanged : " + "wwwwwwwwwwwwwwwwwwwww")

            var stateStr:String = intent.extras?.getString(TelephonyManager.EXTRA_STATE).toString()
            var state:Int
            state=0
            if(stateStr == TelephonyManager.EXTRA_STATE_IDLE){
                state = TelephonyManager.CALL_STATE_IDLE
            }
            else if(stateStr == TelephonyManager.EXTRA_STATE_OFFHOOK){
                state = TelephonyManager.CALL_STATE_OFFHOOK
            }
            else if(stateStr == TelephonyManager.EXTRA_STATE_RINGING){
                state = TelephonyManager.CALL_STATE_RINGING
            }
            onCallStateChanged(context, state)
        }
    }
    protected fun onIncomingCallStarted(ctx: Context,  start: Date) {
        startRecorderService(ctx, Constants.INCOMING_CALL_STARTED)

        Log.v(TAG, "onCallStateChanged : " + "onIncomingCallStarted")
    }
    protected fun onOutgoingCallStarted(ctx: Context,  start: Date) {
        startRecorderService(ctx, Constants.OUTGOING_CALL_STARTED)
        Log.v(TAG, "onCallStateChanged : " + "onOutgoingCallStarted")
    }
    protected fun onIncomingCallEnded(ctx: Context,  start: Date?, end: Date?) {
        startRecorderService(ctx, Constants.INCOMING_CALL_ENDED)
        Log.v(TAG, "onCallStateChanged : " + "onOutgoingCallStarted")

    }
    protected fun onOutgoingCallEnded(ctx: Context, start: Date?, end: Date?) {
        startRecorderService(ctx, Constants.OUTGOING_CALL_ENDED)
        Log.v(TAG, "onCallStateChanged : " + "onOutgoingCallEnded")

    }
    protected fun onMissedCall(ctx: Context,  start: Date?) {
        startRecorderService(ctx, Constants.MISSED_CALL)
        Log.v(TAG, "onCallStateChanged : " + "onOutgoingCallStarted")

    }

    fun onCallStateChanged(context: Context, state: Int) {
        Log.v("aaa","ss   "+ static.lastState+"     "+state)

        if (static.lastState === state) {
            //No change, debounce extras
            Log.v("aaa","lassssssssssssssssssssssss")
            return
        }
        when (state) {
            TelephonyManager.CALL_STATE_RINGING -> {
                //if (DEBUG) Log.i(TAG, "onCallStateChanged : " + "CALL_STATE_RINGING")
                isIncoming = true
                callStartTime = Date()
                onIncomingCallStarted(context, callStartTime!!)
            }
            TelephonyManager.CALL_STATE_OFFHOOK -> {
                if (static.lastState !== TelephonyManager.CALL_STATE_RINGING) {
                    isIncoming = false
                    callStartTime = Date()
                    onOutgoingCallStarted(context, callStartTime!!)
                }
            }
            TelephonyManager.CALL_STATE_IDLE -> {
                //Went to idle-  this is the end of a call.  What type depends on previous state(s)
                if (static.lastState === TelephonyManager.CALL_STATE_RINGING) {
                    //Ring but no pickup-  a miss
                    onMissedCall(context,  callStartTime)

                } else if (isIncoming) {
                    onIncomingCallEnded(context,  callStartTime, Date())

                } else {
                    onOutgoingCallEnded(context,  callStartTime, Date())
                }
            }
        }
        static.lastState = state
    }
    private fun startRecorderService(
        context: Context, stateCall: Int)
    {
        val myIntent = Intent(context, RecordSercice::class.java)
        myIntent.putExtra(Constants.COMMAND_TYPE, stateCall)
        myIntent.putExtra(Constants.PHONE_NUMBER, "unknown")
        context.startService(myIntent)

    }
}
