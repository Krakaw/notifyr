package za.co.locotec.notifyr

import android.Manifest
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import za.co.locotec.notifyr.databinding.ActivityScrollingBinding
import java.lang.Exception
import java.security.AccessController.getContext
import android.content.Intent
import android.app.NotificationManager
import android.content.Context
import android.widget.ArrayAdapter
import android.widget.ListView


class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val listView = findViewById<ListView>(R.id.notification_list_view)
        val adapter = NotificationAdapter(this, arrayListOf(NotificationData("WhatsApp", "tite", "Blah blah blah"),NotificationData("WhatsApp", "tite", "Blah blah blah"),NotificationData("WhatsApp", "tite", "Blah blah blah"),NotificationData("WhatsApp", "tite", "Blah blah blah")))
        listView.adapter = adapter

        if (!isNotificationPolicyAccessGranted()) {
            val intent = Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS")
            startActivity(intent)
        }



    }
    private fun isNotificationPolicyAccessGranted(): Boolean {
        val notificationManager =
            this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        return notificationManager.isNotificationPolicyAccessGranted
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}