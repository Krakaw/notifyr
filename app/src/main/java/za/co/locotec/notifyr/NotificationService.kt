package za.co.locotec.notifyr

import android.app.Notification
import android.content.Intent
import android.os.IBinder
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.graphics.Bitmap

import android.os.Bundle
import android.util.Log
import android.os.Parcelable

import android.os.Build





class NotificationService : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification?) {


        super.onNotificationPosted(sbn)

        val pack = sbn!!.packageName
        var ticker = ""
        if (sbn!!.notification.tickerText != null) {
            ticker = sbn!!.notification.tickerText.toString()
        }
        val extras = sbn!!.notification.extras
        val title = extras.getString("android.title")
        val text = extras.getCharSequence("android.text").toString()


        Log.i("Package", pack)
        Log.i("Ticker", ticker)
        if (title != null) {
            Log.i("Title", title)
        }
        Log.i("Text", text)
    }

}