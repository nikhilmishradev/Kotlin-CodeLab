package com.androidtechguru.kotlinpractice.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.androidtechguru.kotlinpractice.R
import kotlinx.coroutines.channels.Channel

class MyForegroundService : Service() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Start your foreground service here
        // Create a notification to keep the service running in the foreground

        val notification = NotificationCompat.Builder(this, "20")
            .setContentTitle("My Foreground Service")
            .setContentText("Service is running in the foreground")
            .setSmallIcon(R.mipmap.ic_launcher)
            .build()

        startForeground(1,notification)

        return START_NOT_STICKY
    }
    override fun onBind(intent: Intent): IBinder? {
//        TODO("Return the communication channel to the service.")
    return null
    }


}