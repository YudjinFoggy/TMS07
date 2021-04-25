package com.example.tms07

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HW5ActivityRegistered : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw5_registered)

        val welcomeLogin = findViewById<TextView>(R.id.final_text)
        val tempText =
            resources.getString(R.string.welcome) + intent.extras?.get("welcome").toString();
        welcomeLogin.text = tempText
    }
}