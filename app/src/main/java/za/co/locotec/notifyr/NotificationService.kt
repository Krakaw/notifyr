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

        Log.i("Service", "I'm here")

        super.onNotificationPosted(sbn)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            val b = extras.get(Notification.EXTRA_MESSAGES)
//            if (b != null) {
//                for (tmp in b) {
//                    val msgBundle = tmp as Bundle
//                    content = content.toString() + msgBundle.getString("text") + "\n"
//
//                    /*Set<String> io = msgBundle.keySet(); // To get the keys available for this bundle*/
//                }
//            }
//        }
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