package com.diegomfv.splendidrecipesmvvm.ui.common

import timber.log.Timber

fun logSth (msg: String) {
    Timber.i("Logging__: $msg")
}

fun logSentToServer (string: String) {
    Timber.i("Sent to Server: $string")
}