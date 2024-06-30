package com.qamar.yassirnavigationexample.ui.util

import android.os.Handler
import android.os.Looper

fun <T> (() -> T).withDelay(delay: Long = 250L) {
    Handler(Looper.getMainLooper()).postDelayed({ this.invoke() }, delay)
}