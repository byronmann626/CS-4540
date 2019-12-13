package com.example.finalproject



import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.CONTEXT_IGNORE_SECURITY
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService

class AlarmReceiver : BroadcastReceiver() {
    private lateinit var context:Context
    override fun onReceive(context: Context, intent: Intent) {
        this.context=context
        // Is triggered when alarm goes off, i.e. receiving a system broadcast
        if (intent.action == "FOO_ACTION") {
            val fooString = intent.getStringExtra("KEY_FOO_STRING")
            Toast.makeText(context, fooString, Toast.LENGTH_LONG).show()
            Log.d("print","BROADCAST RECEIVER_+_+_+_+_+_")
            val channelId =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    createNotificationChannel("24", "Alarm Channel")
                } else {
                    // If earlier version channel ID is not used
                    // https://developer.android.c        om/reference/android/support/v4/app/NotificationCompat.Builder.html#NotificationCompat.Builder(android.content.Context)
                    ""
                }
            val notificationIntent = Intent(context, MainActivity::class.java)
            notificationIntent.action = "My action"  // A string containing the action name
            val contentPendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0)
            val notification = NotificationCompat.Builder(context,channelId)
                .setContentTitle("TITLE")
                .setTicker("TICKER")
                .setContentText("THis is my content text")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(contentPendingIntent)
                .setOngoing(true)

            val service = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            service.notify(0, notification.build())

        }

    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(channelId: String, channelName: String): String{
        val chan = NotificationChannel(channelId,
            channelName, NotificationManager.IMPORTANCE_HIGH)
        chan.lightColor = Color.BLUE
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val service = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        service.createNotificationChannel(chan)
        return channelId
    }
}
