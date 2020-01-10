package com.diegomfv.splendidrecipesmvvm.ui.common

import android.content.Context
import android.widget.Toast
import timber.log.Timber

fun Context.toast (msg: String, lengthLong : Boolean = false) {
    Toast.makeText(this, msg, if (lengthLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
}

fun logSth (msg: String) {
    Timber.i("Logging__: $msg")
}

fun logSentToServer (string: String) {
    Timber.i("Sent to Server: $string")
}