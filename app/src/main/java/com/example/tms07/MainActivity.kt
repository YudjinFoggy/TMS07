package com.example.tms07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonHw1 = findViewById<Button>(R.id.hw1)
        buttonHw1.setOnClickListener {
            startActivity(Intent(this, HW1Activity::class.java))
        }
    }





}