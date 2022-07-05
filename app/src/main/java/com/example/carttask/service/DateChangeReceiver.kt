package com.example.carttask.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter

abstract class DateChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action.equals(Intent.ACTION_DATE_CHANGED) ||
            intent?.action.equals(Intent.ACTION_TIME_CHANGED)
        ) {
            onOpenAppCheckDateChanged()
        }
    }

    abstract fun onOpenAppCheckDateChanged()

    companion object {

        fun getIntentFilter() = IntentFilter().apply {
            addAction(Intent.ACTION_DATE_CHANGED)
            addAction(Intent.ACTION_TIME_CHANGED)
        }
    }
}
