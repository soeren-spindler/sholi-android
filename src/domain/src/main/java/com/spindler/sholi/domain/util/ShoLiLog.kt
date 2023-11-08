package com.spindler.sholi.domain.util

import android.util.Log

class ShoLiLog {
    companion object {
        fun i(caller: Any, message: String) {
            Log.i(caller::class.simpleName, message)
        }

        fun i(tag: String, message: String) {
            Log.i(tag, message)
        }
    }
}
