@file:Suppress("DEPRECATION")

package com.example.tms07.dz9

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModelProvider
import com.example.tms07.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class HW9Activity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel9::class.java) }

    companion object {
        const val BROADCAST_ACTION = "action"
        const val NOTIFICATION_ID = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw9)

        val myReceiver = MyBroadcastReceiver(viewModel)

        val intentFiler = IntentFilter().apply {
            addAction(BROADCAST_ACTION)
            addAction("android.intent.action.AIRPLANE_MODE")
        }

        registerReceiver(myReceiver, intentFiler)

        val timer = findViewById<TextView>(R.id.timer)
        findViewById<TextView>(R.id.timer_button).setOnClickListener {
            it.visibility = View.INVISIBLE
            getTimerObserve(timer)
        }

        getAdviceObserve()
    }

    private fun getNotification() {

        val contentIntent = PendingIntent.getActivity(
            this, 666,
            Intent(this, HW9Activity::class.java),
            PendingIntent.FLAG_CANCEL_CURRENT

        )

        val intent = Intent().apply {
            action = BROADCAST_ACTION
        }

        val actionIntent =
            PendingIntent.getBroadcast(
                this,
                666,
                intent,
                PendingIntent.FLAG_CANCEL_CURRENT
            )

        val notification = NotificationCompat.Builder(this)
            .setSmallIcon(R.drawable.ic_baseline_smoking_rooms_24)
            .setContentTitle("Saw")
            .setContentText("You get message")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(contentIntent)
            .setOngoing(true)
            .addAction(
                R.drawable.ic_baseline_touch_app_24,
                getString(R.string.read_me),
                actionIntent
            )
            .setAutoCancel(true)
            .build()

        val manager = getSystemService(NotificationManager::class.java)
        manager.notify(NOTIFICATION_ID, notification)
    }

    private fun getTimerObserve(timer: TextView) {

        viewModel.startTimer()
        viewModel.timeLeft.observe(this) {
            if (it == 0) {
                getNotification()
            }
            timer.text = it.toString()
        }
    }

    private fun getAdviceObserve() {

        viewModel.loadAdvice("0")

        viewModel.errorBus.observe(this) {
            MaterialAlertDialogBuilder(this)
                .setTitle(getString(R.string.error))
                .setMessage(it)
                .show()
        }
    }
}



