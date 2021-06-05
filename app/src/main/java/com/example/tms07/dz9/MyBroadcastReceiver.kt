package com.example.tms07.dz9

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class MyBroadcastReceiver(viewModel9: MainViewModel9) : BroadcastReceiver() {

    private val viewModel = viewModel9
    override fun onReceive(context: Context?, intent: Intent?) {
        val manager = context?.getSystemService(NotificationManager::class.java)

        Toast.makeText(context, viewModel.rates.value?.advice.toString(), Toast.LENGTH_SHORT).show()
        manager?.cancel(1)
        context?.startActivity(Intent(context, HW9Activity::class.java))
    }
}