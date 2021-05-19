package com.example.tms07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tms07.dz8.HW8Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonHw1 = findViewById<Button>(R.id.hw1)
        val buttonHw2 = findViewById<Button>(R.id.hw2)
        val buttonHw3 = findViewById<Button>(R.id.hw3)
        val buttonHw4 = findViewById<Button>(R.id.hw4)
        val buttonHw5 = findViewById<Button>(R.id.hw5)
        val buttonHw6 = findViewById<Button>(R.id.hw6)
        val buttonHw7 = findViewById<Button>(R.id.hw7)
        val buttonHw8 = findViewById<Button>(R.id.hw8)

        buttonHw1.setOnClickListener {
            startActivity(Intent(this, HW1Activity::class.java))
        }

        buttonHw2.setOnClickListener {
            startActivity(Intent(this, HW2Activity::class.java))
        }

        buttonHw3.setOnClickListener {
            startActivity(Intent(this, HW3Activity::class.java))
        }

        buttonHw4.setOnClickListener {
            startActivity(Intent(this, HW4Activity::class.java))
        }

        buttonHw5.setOnClickListener {
            startActivity(Intent(this, HW5Activity::class.java))
        }

        buttonHw6.setOnClickListener {
            startActivity(Intent(this, HW6Activity::class.java))
        }

        buttonHw7.setOnClickListener {
            startActivity(Intent(this, HW7Activity::class.java))
        }

        buttonHw8.setOnClickListener {
            startActivity(Intent(this, HW8Activity::class.java))
        }
    }
}