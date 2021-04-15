package com.example.tms07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HW2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw2)

        val buttonFlags = findViewById<Button>(R.id.buttonFlags)
        val buttonAnimation = findViewById<Button>(R.id.buttonAnimation)

        buttonFlags.setOnClickListener {
            startActivity(Intent(this, FlagsActivity::class.java))
        }

        buttonAnimation.setOnClickListener {
            startActivity(Intent(this, AnimationActivity::class.java))
        }
    }
}