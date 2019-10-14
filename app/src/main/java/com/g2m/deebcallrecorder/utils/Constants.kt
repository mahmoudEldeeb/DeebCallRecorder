package com.g2m.deebcallrecorder.utils

public object Constants {

    var DEBUG = true
    var isAds = false
    var TEST_DEVICE_ID = "AB4B5A5E730E688BCC7C0E8D551611F3"
    var TAG = "S_CallRecorder"
    var TRUE = 1
    var FALSE = 0

    // Key setting for Preferences
    var PREFS_NAME = "Setting_prefs"
    var SERVICE_ENABLED = "ServiceEnabled"
    var KEY_ENABLE_NOTIFICATION = "is_enable_notication"
    var KEY_NOTIFICATION_ALWAYS_ASK = "notification_always_ask"
    var KEY_MODE_RECORDER = "mode_recorder"
    var KEY_PRIORITY_CONTACT = "priority_contacts_manage"
    var KEY_INBOX_SIZE = "inbox_size"
    var KEY_SHAKE_CANCEL_RECORD = "is_shake_cancel_record"
    var KEY_PRIVATE_MODE = "is_enable_private_mode"
    var KEY_USE_24_HOUR_FORMAT = "is_use_24_hour_format"
    var KEY_BEEP_SOUND = "is_beep_sound_when_record"
    var KEY_ACTION_WHEN_NOTE = "action_when_note"
    // Audio source
    var KEY_AUDIO_SOURCE = "key_audio_source"
    var MIC = 6000
    var VOICE_CALL = 6001
    var VOICE_COMMUNICATION = 6002
    var CAMCORDER = 6003
    var VOICE_RECOGNITION = 6004
    var VOICE_UPLINK = 6005
    var VOICE_DOWNLINK = 6006
    var MODE_RECORDER_RECORD_ALL = 100
    var MODE_RECORDER_AUDIO_RECORDER_FILE_EXT_3GPCONTACTS_ONLY = 101
    var MODE_RECORDER_PRIORITY_CONTACTS = 102
    var MODE_RECORDER_UNKNOW_NUMBER = 103

    var MAXIMUM_INBOX_SIZE_10 = 10
    var MAXIMUM_INBOX_SIZE_50 = 50
    var MAXIMUM_INBOX_SIZE_100 = 100
    var MAXIMUM_INBOX_SIZE_500 = 500
    var MAXIMUM_INBOX_SIZE_UNLIMITED = 1000

    var KEY_FILE_TYPE_OUTPUT = "file_type_output"
    var FILE_TYPE_3GP = 1000
    var FILE_TYPE_WAV = 1002
    var FILE_TYPE_MP4 = 1003
    var FILE_TYPE_AMR = 1004

    var AUTOMATIC_SAVE_RECORDING = 700
    var ASK_WHAT_TO_DO = 701
    var DONT_SAVE = 702

    // For utils upgrade
    var KEY_IS_THE_FIRST_OPEN_APP = "firstTime_app_upgrade"
    var KEY_IS_THE_FIRST_NO_MEDIA = "fistTime_hide_media"
    var KEY_OLDVERSION_DATABSE = "key_old_version_database"

    // For engine recorder
    var COMMAND_TYPE = "commandType"
    var PHONE_NUMBER = "phoneNumber"
    var SLIENT_MODE = "silentMode"
    var INCOMING_CALL_STARTED = 51
    var OUTGOING_CALL_STARTED = 52
    var INCOMING_CALL_ENDED = 53
    var OUTGOING_CALL_ENDED = 54
    var MISSED_CALL = 55

    // For Storage manager
    var KEY_NAME_FOLDER_SAVE_DATA = "key_name_folder_save_data"
    var FILE_DIRECTORY = "SMAStudios_Recorder"

    // For Dialog rate
    val KEY_EXCEPTION = "key_exception"


    //broadcast key
    var ACTION_BROADCAST_INBOX_INTENT_UPDATE_LIST_RECORD = "com.SMAStudios.Call_Recording_program.inbox.updatelist"
    var ACTION_BROADCAST_INBOX_INTENT_UPDATE_NOTE = "com.SMAStudios.Call_Recording_program.player.inbox.updatenote"
    var ACTION_BROADCAST_SAVED_INTENT_UPDATE_LIST_RECORD = "com.SMAStudios.Call_Recording_program.saved.updatelist"
    var ACTION_BROADCAST_SAVED_INTENT_UPDATE_NOTE = "com.SMAStudios.Call_Recording_program.player.saved.updatenote"
    var ACTION_BROADCAST_INBOX_INTENT_UPDATE_LIST_RECORD_NAME = "com.SMAStudios.Call_Recording_program.inbox.updatename"
    var ACTION_BROADCAST_INTENT_DELETE_ALL = "com.SMAStudios.Call_Recording_program.storage.deleteall"

    var TYPE_ADAPTER_INBOX_FRAGMENT = 0
    var TYPE_ADAPTER_SAVED_FRAGMENT = 1

    //Player
    var FROM_RECORDING = 10000
    var FROM_FAVORITE = 10001
    var FROM_SEARCH = 10002
    var MAIN_ACTIVITY = 5000
    var PRIORITY_CONTACT_ACTIVITY = 5001
    var FROM_SETTING = 5003
    var PLAYER_ACTIVITY = 5004
    var KEY_SEND_RECORD_TO_PLAYER = "key_send_record_to_player"
    var KEY_ACTIVITY = "activity"
    var KEY_RECORD_TYPE_PLAY = "key_record_type_play"
    var UPDATE_NOTE_BROADCAST = 300
    var UPDATE_SAVED_BROADCAST = 301

    var KEY_DONT_SHOW_AGAIN = "key_dont_show_again"

    //For helpActivity
    var KEY_ABOUT_APP_VERSION = "key_about_app_version"
    var KEY_ABOUT_APP_LICENSE = "key_about_app_license"
    var KEY_ABOUT_APP_GET_ALL_APP = "key_about_app_get_all_app"
    var KEY_ABOUT_APP_FEEDBACK = "key_about_app_feedback"
    var KEY_ABOUT_APP_ON_GOOGLEPLUS = "key_about_app_smobile_on_googleplus"
    var KEY_ABOUT_APP_TRANSLATION = "key_about_app_translation"

    //Cloud
    var IS_DROPBOX_LINKED = "is_dropbox_linked"
    var MODE_UPLOAD_FOLDER = "9000"
    var MODE_UPLOAD_ONE_FILE = "9001"
    var ACCOUNT_PREFS_NAME = "acount_prefs"
    var IS_ENABLE_GOOGLE_DRIVE = false
    var KEY_DRIVE_ACCOUNT = "key_drive_account"
    var KEY_DROPBOX_ACCOUNT = "key_dropbox_account"
    var KEY_AUTOMATIC_SYNC = "cloud_sync_automatic"
    var KEY_CLOUD_SYNC_WIFI_ONLY = "cloud_sync_wifi_only"
    var KEY_IS_THE_FIRST_SYNC_AFTER_AUTHENTICATION = "key_is_the_first_sync_after_authentication"
    var ACCESS_KEY_NAME = "access_key"
    var ACCESS_SECRET_NAME = "access_secret"
    var DROPBOX_APP_KEY = "9ow92p00n5gupkr"
    var DROPBOX_APP_SECRET = "e8xh1qtj6hkh5mv"

    // For private mode
    val KEY_PASSWORD_FOR_PRIVATE_MODE = "password"
    val KEY_IS_LOGINED = "is_logined"
}